package com.softnovo.service;

import com.softnovo.domain.JpaOrder;
import com.softnovo.repository.OrderJpaRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("jpaOrderService")
public class JpaOrderService {
    @Resource
    private OrderJpaRepository orderJpaRepository;

    public JpaOrder getOrderById(Long orderId) {
        return orderJpaRepository.getOne(orderId);
    }

    public JpaOrder getOrderByOrderNumberWithQuery(String orderNumber) {
        return orderJpaRepository.getOrderByOrderNumberWithQuery(orderNumber);
    }



}
