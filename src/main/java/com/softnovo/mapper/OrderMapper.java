package com.softnovo.mapper;

import com.softnovo.domain.Order;

import java.util.List;

public interface OrderMapper {
    List<Order> getAll();

    Order getOne(Long id);

    void insert(Order order);

    void update(Order order);

    void delete(Long id);
}
