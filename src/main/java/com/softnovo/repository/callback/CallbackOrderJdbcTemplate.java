package com.softnovo.repository.callback;

import com.softnovo.domain.Order;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("callbackOrderJdbcTemplate")
public class CallbackOrderJdbcTemplate extends AbstractJdbcTemplate {
    @Resource
    protected DataSource dataSource;

    @Override
    protected Object handleResultSet(ResultSet rs) throws SQLException {
        List<Order> orders = new ArrayList<Order>();
        while (rs.next()) {
            Order order = new Order(rs.getLong("id"), rs.getString("order_number"), rs.getString("delivery_address"));
            orders.add(order);
        }
        return orders;
    }

    @Override
    protected DataSource getDataSource() {
        return dataSource;
    }
}
