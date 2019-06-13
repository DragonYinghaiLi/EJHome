package com.okami.apps.ej.service;

import com.okami.apps.ej.bean.OrderLine;

import java.util.List;

public interface IOrderLineService {
    List<OrderLine> findAll();
    void deleteById(long id) throws Exception;
}
