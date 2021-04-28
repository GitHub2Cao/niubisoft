package com.softnovo.service;

import com.softnovo.domain.JpaOrder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class JpaOrderServiceTests {
    @Resource
    private JpaOrderService jpaOrderService;

    @Test
    void getOrderById() {
        JpaOrder jpaOrder = jpaOrderService.getOrderById(1L);
        System.out.println("=======" + jpaOrder);
    }
    @Test
    void getOrderByOrderNumberWithQuery() {
        JpaOrder jpaOrder = jpaOrderService.getOrderByOrderNumberWithQuery("Order10002");
        System.out.println("=======" + jpaOrder);
    }
}
