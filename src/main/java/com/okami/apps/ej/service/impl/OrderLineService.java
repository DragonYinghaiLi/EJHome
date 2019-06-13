package com.okami.apps.ej.service.impl;

import com.okami.apps.ej.bean.OrderLine;
import com.okami.apps.ej.bean.OrderLineExample;
import com.okami.apps.ej.dao.OrderLineMapper;
import com.okami.apps.ej.service.IOrderLineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderLineService implements IOrderLineService {
    @Resource
    private OrderLineMapper orderlineMapper;

    @Override
    public List<OrderLine> findAll() {
        OrderLineExample example=new OrderLineExample();
        return orderlineMapper.selectByExample(example);
    }

    @Override
    public void deleteById(long id) throws Exception {
        OrderLine orderLine=orderlineMapper.selectByPrimaryKey(id);
        if(orderLine==null){
            throw  new Exception("要删除顾客不存在");
        }else{
            orderlineMapper.deleteByPrimaryKey(id);
        }
    }

}
