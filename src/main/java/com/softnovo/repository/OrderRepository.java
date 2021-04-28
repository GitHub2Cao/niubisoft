package com.softnovo.repository;

import com.softnovo.domain.Order;

public interface OrderRepository {
    Order addOrder(Order order);
    Order getOrderById(Long orderId);
    Order getOrderDetailByOrderNumber(String orderNumber);
}
