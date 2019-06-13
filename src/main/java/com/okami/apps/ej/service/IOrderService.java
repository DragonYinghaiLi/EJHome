package com.okami.apps.ej.service;

import com.okami.apps.ej.bean.Order;

import java.util.List;

public interface IOrderService {
    List<Order> findAll();
    void deleteById(long id) throws Exception;
}
