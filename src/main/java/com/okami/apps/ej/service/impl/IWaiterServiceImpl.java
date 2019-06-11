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

    /**
     * 通过id查询服务员
     * @return
     */
    @Override
    public List<Waiter> findAll() {
        WaiterExample example=new WaiterExample();
        return waiterMapper.selectByExample(example);
    }

    /***
     * 添加服务员
     * @param waiter
     * @throws Exception
     */
    @Override
    public void save(Waiter waiter) throws Exception{
        if(waiter.getId()==null){
            waiterMapper.insert(waiter);
        }else{
            System.out.println("服务员已存在");
        }
    }

    /***
     * 修改操作
     * @param waiter
     * @throws Exception
     */
    @Override
    public  void update(Waiter waiter) throws Exception{
        waiterMapper.updateByPrimaryKeySelective(waiter);
    }


    /***
     * 删除
     * @param id
     * @throws Exception
     */
    @Override
    public void deleteById(long id) throws Exception {
        Waiter customer=waiterMapper.selectByPrimaryKey(id);
        if(customer==null){
            throw  new Exception("要删除服务员不存在");
        }else{
            waiterMapper.deleteByPrimaryKey(id);
        }
    }

}
