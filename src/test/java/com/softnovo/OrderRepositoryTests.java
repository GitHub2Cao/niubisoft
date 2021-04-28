package com.softnovo;

import com.alibaba.fastjson.JSON;
import com.softnovo.domain.Order;
import com.softnovo.repository.OrderRepository;
import com.softnovo.repository.callback.AbstractJdbcTemplate;
import com.softnovo.repository.callback.CallbackJdbcTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class OrderRepositoryTests {
    @Resource
    private OrderRepository orderRawJdbcRepository;
    @Resource
    private OrderRepository orderJdbcRepository;
    @Resource
    private AbstractJdbcTemplate callbackOrderJdbcTemplate;
    @Resource
    private CallbackJdbcTemplate callbackJdbcTemplate;
    @Test
    void callback() {
        Object obj = callbackJdbcTemplate.queryOrder("select id, order_number, delivery_address from `order` where id = 1");
        System.out.println("=======" + obj);
    }

    @Test
    void executeTemplate() {
        Object obj = callbackOrderJdbcTemplate.execute("select id, order_number, delivery_address from `order` where id = 1");
        System.out.println("===========" + obj);
    }

    @Test
    void getOrderById() {
        Order order = orderRawJdbcRepository.getOrderById(1L);
        System.out.println("_+_+_+_+_+_+_+_+ " + order);

        order = orderJdbcRepository.getOrderById(1L);
        System.out.println("++++++++++++++" + order);
    }

    @Test
    void getOrderDetailByOrderNumber() {
        Order order = orderJdbcRepository.getOrderDetailByOrderNumber("1");
        System.out.println("++++++++++++++" + order);
    }

    @Test
    void addOrder() {
        String text = "{\n" +
                "\n" +
                "\"orderNumber\":\"Order10002\",\n" +
                "\n" +
                "\"deliveryAddress\":\"test_address2\",\n" +
                "\n" +
                "\"goods\":[\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"id\":1,\n" +
                "\n" +
                "\"goodsCode\":\"GoodsCode1\",\n" +
                "\n" +
                "\"goodsName\":\"GoodsName1\",\n" +
                "\n" +
                "\"price\":100.0\n" +
                "\n" +
                "}\n" +
                "\n" +
                "]\n" +
                "\n" +
                "}\n";
        Order order = JSON.parseObject(text, Order.class);
        Order newOrder = orderJdbcRepository.addOrder(order);
        System.out.println("------------ " + newOrder);
    }
}
