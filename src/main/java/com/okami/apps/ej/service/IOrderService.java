package com.okami.apps.ej.service;

import com.okami.apps.ej.bean.Order;

import java.util.List;

/***
 * 订单接口
 */
public interface IOrderService {
    //查询所有订单
    List<Order> findAllOrder();
    //模糊查询
    List<Order> queryOrder(Order order);
    //根据id查询
    Order findOrderById(long id);
    //插入新的订单项
    void insertOrder(Order order)throws Exception;
    //修改订单项
    void updateOrderPrimaryKey(Order order)throws Exception;
    //根据id删除
    void deleteOrderById(long id) throws Exception ;
    //批量删除
    void batchDeleteOrder(long ids[]) throws Exception ;
}
