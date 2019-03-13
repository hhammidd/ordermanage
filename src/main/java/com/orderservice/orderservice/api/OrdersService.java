package com.orderservice.orderservice.api;

import com.orderservice.orderservice.web.dto.output.OrdersTo;

import java.util.List;

public interface OrdersService {

    OrdersTo getById(long id);

    List<OrdersTo> getByCustomerId(long customerId);

    List<OrdersTo> getAll();

    OrdersTo create(OrdersTo orders);

    OrdersTo update(OrdersTo orders);

    boolean deleteOrder(long ordersId);
}
