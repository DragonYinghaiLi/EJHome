package com.okami.apps.ej.service.impl;

import com.okami.apps.ej.bean.Waiter;
import com.okami.apps.ej.bean.WaiterExample;
import com.okami.apps.ej.dao.WaiterMapper;
import com.okami.apps.ej.service.IWaiterService;

import javax.annotation.Resource;
import java.util.List;

public class WaiterServiceImpl implements IWaiterService {

    @Resource
    private WaiterMapper waiterMapper;

    @Override
    public List<Waiter> query(Waiter waiter){
        WaiterExample example = new WaiterExample();
        if(waiter.getRealname()!=null){
            example
                    .createCriteria()
                    .andRealnameLike("%"+waiter.getRealname()+"%");
        }
        if(waiter.getTelephone()!=null){
            example
                    .createCriteria()
                    .andRealnameLike("%"+waiter.getTelephone()+"%");
        }
        if(waiter.getIdcard()!=null){
            example
                    .createCriteria()
                    .andRealnameLike("%"+waiter.getIdcard()+"%");
        }
        return waiterMapper.selectByExample(example);
    }
    @Override
    public List<Waiter> findAll(){
        WaiterExample example = new WaiterExample();
        return waiterMapper.selectByExample(example);
    }
    @Override
    public Waiter findById(long id){
        return waiterMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Waiter waiter) throws Exception {
        if (waiter.getId()==null){
            waiter.setStatus("正常");
            waiterMapper.insert(waiter);
        }else {
            waiterMapper.updateByPrimaryKey(waiter);
        }
    }


    @Override
    public void deleteById(long id) throws Exception{
        Waiter waiter = waiterMapper.selectByPrimaryKey(id);
        if (waiter==null){
            throw new Exception("要删的顾客不存在");
        }else {
            waiterMapper.deleteByPrimaryKey(id);
        }
    }

}