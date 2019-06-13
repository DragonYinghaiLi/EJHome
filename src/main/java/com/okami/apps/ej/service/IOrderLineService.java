package com.okami.apps.ej.service;

import com.okami.apps.ej.bean.OrderLine;

import java.util.List;

public interface IOrderLineService {

    List<OrderLine> findAll();
    OrderLine findById(long id);
    List<OrderLine> query(OrderLine orderLine);
    void deleteById(long id) throws Exception;
    void saveOrUpdate(OrderLine orderLine) throws Exception;
    void batchDelete(long[] ids) throws Exception;
}
