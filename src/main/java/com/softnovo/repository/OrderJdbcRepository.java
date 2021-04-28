package com.softnovo.repository;

import com.softnovo.domain.Goods;
import com.softnovo.domain.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("orderJdbcRepository")
public class OrderJdbcRepository implements OrderRepository {
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Override
    public Order addOrder(Order order) {
        Long orderId = saveOrderWithJdbcTemplate(order);
        order.setId(orderId);
        List<Goods> goodsList = order.getGoodsList();
        if (!CollectionUtils.isEmpty(goodsList)) {
            goodsList.forEach(goods -> {
                saveGoodsToOrderWithJdbcTemplate(goods, orderId);
            });

        }
        return order;
    }

    private void saveGoodsToOrderWithJdbcTemplate(Goods goods, Long orderId) {
        jdbcTemplate.update("insert into order_goods (order_id, goods_id) " + "values (?, ?)", orderId, goods.getId());
    }

    private Long saveOrderWithJdbcTemplate(Order order) {
        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement("insert into `order` (order_number, delivery_address) values (?, ?)",
                         Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, order.getOrderNumber());
                ps.setString(2, order.getDeliveryAddress());
                return ps;
            }
        };

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(psc, keyHolder);
        return keyHolder.getKey().longValue();
    }

    @Override
    public Order getOrderById(Long orderId) {
        String sql = "select id, order_number, delivery_address from `order` where id=?";
        return jdbcTemplate.queryForObject(sql, this::mapRowToOrder, orderId);
    }

    private Order mapRowToOrder(ResultSet rs, int rowNum) throws SQLException {
        return new Order(rs.getLong("id"), rs.getString("order_number"), rs.getString("delivery_address"));
    }

    @Override
    public Order getOrderDetailByOrderNumber(String orderNumber) {
        String sql = "select id, order_number, delivery_address from `order` where order_number= ? ";
        Order order = jdbcTemplate.queryForObject(sql, this::mapRowToOrder, orderNumber);
        if (order == null) {
            return null;
        }

        Long orderId = order.getId();
        String googsSql = "select order_id, goods_id from order_goods where order_id=?";
        List<Long> goodsIds = jdbcTemplate.query(googsSql,
                new ResultSetExtractor<List<Long>>() {
                    @Override
                    public List<Long> extractData(ResultSet rs) throws SQLException, DataAccessException {
                        List<Long> list = new ArrayList<Long>();
                        while (rs.next()) {
                            list.add(rs.getLong("goods_id"));
                        }
                        return list;
                    }
                }, orderId);

        if (!CollectionUtils.isEmpty(goodsIds)) {
            goodsIds.forEach(goodId -> {
                Goods goods = getGoodsById(goodId);
                order.getGoodsList().add(goods);
            });
        }

        return order;
    }

    public Goods getGoodsById(Long goodsId) {
        return jdbcTemplate.queryForObject("select id, goods_code, goods_name, price from goods where id=?",
                this::mapRowToGoods, goodsId);
    }

    private Goods mapRowToGoods(ResultSet rs, int rowNum) throws SQLException {
        return new Goods(rs.getLong("id"), rs.getString("goods_code"), rs.getString("goods_name"),
                rs.getDouble("price"));
    }
}
