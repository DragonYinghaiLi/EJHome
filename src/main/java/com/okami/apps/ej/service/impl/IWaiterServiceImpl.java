package com.okami.apps.ej.service.impl;

import com.okami.apps.ej.bean.Waiter;
import com.okami.apps.ej.bean.WaiterExample;
import com.okami.apps.ej.dao.WaiterMapper;
import com.okami.apps.ej.service.IWaiterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IWaiterServiceImpl implements IWaiterService {
    @Resource
    private WaiterMapper waiterMapper;

    @Override
    public List<Waiter> findAll() {
        WaiterExample example=new WaiterExample();
        return waiterMapper.selectByExample(example);
    }

    @Override
    public void deleteById(long id) throws Exception {
        Waiter waiter=waiterMapper.selectByPrimaryKey(id);
        if(waiter==null){
            throw  new Exception("要删除服务人员不存在");
        }else{
            waiterMapper.deleteByPrimaryKey(id);
        }
    }

}
