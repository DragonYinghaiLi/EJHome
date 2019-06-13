package com.okami.apps.ej.service;

import com.okami.apps.ej.bean.Order;

import java.util.List;

public interface IOrderService {

    List<Order> findAll();
    Order findById(long id);
    List<Order> query(Order order);
    void deleteById(long id) throws Exception;
    void saveOrUpdate(Order order) throws Exception;
    void batchDelete(long[] ids) throws Exception;
}
