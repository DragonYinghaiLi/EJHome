package com.okami.apps.ej.service;

import com.okami.apps.ej.bean.OrderLine;

import java.util.List;

/**
 * 订单项接口
 */
public interface IOrderLineService {
    //查询所有订单项
    List<OrderLine> findAllOrderLine();
    //模糊查询
    List<OrderLine> query(OrderLine orderLine);
    //根据id查询
    OrderLine findOrderLineById(long id);
    //插入新的订单项
    void insertOrderLine(OrderLine orderLine)throws Exception;
    //修改订单项
    void updateOrderLinePrimaryKey(OrderLine orderLine)throws Exception;
    //根据id删除
    void deleteOrderLineById(long id) throws Exception ;
    //批量删除
    void batchDeleteOrderLine(long ids[]) throws Exception ;
}
