package com.okami.apps.ej.service.impl;

import com.okami.apps.ej.bean.Order;
import com.okami.apps.ej.bean.OrderExample;
import com.okami.apps.ej.dao.OrderMapper;
import com.okami.apps.ej.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> findAll() {
        OrderExample example = new OrderExample();
        return orderMapper.selectByExample(example);
    }


    @Override
    public Order findById(long id) {
        //调用dao层代码完成操作
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Order> query(Order order){
        return orderMapper.query(order);
    }
    @Override
    public void saveOrUpdate(Order order) throws Exception {
        if (order.getId() == null) {
            orderMapper.insert(order);
        } else {
            orderMapper.updateByPrimaryKey(order);
        }
    }



    @Override
    public void deleteById(long id) throws Exception {
        Order order=orderMapper.selectByPrimaryKey(id);
        if(order==null){
            throw  new Exception("要删除的订单信息不存在");
        }else{
            orderMapper.deleteByPrimaryKey(id);
        }
    }
    @Override
    public void batchDelete(long[] ids) throws Exception {
        for(long id :ids){
            orderMapper.deleteByPrimaryKey(id);
        }
    }
}
