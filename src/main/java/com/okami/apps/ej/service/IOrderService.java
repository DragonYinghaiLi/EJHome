package com.okami.apps.ej.service;

import com.okami.apps.ej.bean.Order;
import com.okami.apps.ej.bean.extend.OrderExtend;
import com.okami.apps.ej.bean.vm.OrderAndOrderLineVM;
import com.okami.apps.ej.bean.vm.OrderVM;

import java.util.List;

public interface IOrderService {

    List<OrderVM> queryBasic(Long customerId, Long waiterId);

    List<OrderExtend> query(Long customerId,Long waiterId);

    List<Order> findAll();

    void save(OrderAndOrderLineVM order) throws Exception;

    void deleteById(long id) throws Exception;

    void batchDelete(long[] ids) throws Exception;


}
