package com.okami.apps.ej.service.impl;

import com.okami.apps.ej.bean.OrderLine;
import com.okami.apps.ej.bean.OrderLineExample;
import com.okami.apps.ej.dao.OrderLineMapper;
import com.okami.apps.ej.service.IOrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLineService implements IOrderLineService {
    @Autowired
    private OrderLineMapper orderLineMapper;


    @Override
    public List<OrderLine> findAll() {
        OrderLineExample example = new OrderLineExample();
        return orderLineMapper.selectByExample(example);
    }

    @Override
    public OrderLine findById(long id) {
        //调用dao层代码完成操作
        return orderLineMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<OrderLine> query(OrderLine orderLine){
        return orderLineMapper.query(orderLine);
    }
    @Override
    public void saveOrUpdate(OrderLine orderLine) throws Exception {
        if (orderLine.getId() == null) {
            orderLineMapper.insert(orderLine);
        } else {
            orderLineMapper.updateByPrimaryKey(orderLine);
        }
    }

    @Override
    public void deleteById(long id) throws Exception {
        OrderLine orderLine=orderLineMapper.selectByPrimaryKey(id);
        if(orderLine==null){
            throw  new Exception("要删除不存在");
        }else{
            orderLineMapper.deleteByPrimaryKey(id);
        }
    }
    @Override
    public void batchDelete(long[] ids) throws Exception {
        for(long id :ids){
            orderLineMapper.deleteByPrimaryKey(id);
        }
    }
}
