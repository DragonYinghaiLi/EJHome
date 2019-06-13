package com.okami.apps.ej.service.impl;

import com.okami.apps.ej.bean.Order;
import com.okami.apps.ej.bean.OrderExample;
import com.okami.apps.ej.dao.OrderMapper;
import com.okami.apps.ej.service.IOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public List<Order> findAll() {
        OrderExample example=new OrderExample();
        return orderMapper.selectByExample(example);
    }

    @Override
    public void deleteById(long id) throws Exception {
        Order order=orderMapper.selectByPrimaryKey(id);
        if(order==null){
            throw  new Exception("要删除内容不存在");
        }else{
            orderMapper.deleteByPrimaryKey(id);
        }
    }

}