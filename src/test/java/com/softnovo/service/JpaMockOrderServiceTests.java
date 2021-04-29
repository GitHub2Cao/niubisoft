package com.softnovo.service;

import com.softnovo.domain.JpaOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class JpaMockOrderServiceTests {
    @MockBean
    private JpaOrderService jpaOrderService;

    @Test
    void getOrderByOrderNumberWithQuery() {
        Mockito.when(jpaOrderService.getOrderByOrderNumberWithQuery("Order10002")).thenReturn(new JpaOrder("aaaa", "bbbbb"));
        JpaOrder jpaOrder = jpaOrderService.getOrderByOrderNumberWithQuery("Order10002");
        System.out.println("=======" + jpaOrder);
    }
}
