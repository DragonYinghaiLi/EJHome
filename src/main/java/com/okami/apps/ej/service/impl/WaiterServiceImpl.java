package com.okami.apps.ej.service.impl;

import com.okami.apps.ej.bean.Waiter;
import com.okami.apps.ej.bean.WaiterExample;
import com.okami.apps.ej.dao.WaiterMapper;
import com.okami.apps.ej.service.IWaiterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WaiterServiceImpl implements IWaiterService {
    @Resource
    private WaiterMapper waiterMapper;

    /**
     * 查询服务员
     * @return
     */
    @Override
    public List<Waiter> findAll() {
        WaiterExample example=new WaiterExample();
        return waiterMapper.selectByExample(example);
    }

    /**
     * 通过id查询
     * @param id
     * @return
     */
    @Override
    public Waiter findById(long id) {
        //调用dao层代码完成操作
        return waiterMapper.selectByPrimaryKey(id);
    }

    /**
     * 模糊查询
     * @param waiter
     * @return
     */
    @Override
    public List<Waiter> query(Waiter waiter){
        return waiterMapper.query(waiter);
    }
    /***
     * 添加服务员
     * @param waiter
     * @throws Exception
     */
  @Override
    public void saveOrUpdate(Waiter waiter) throws Exception{
        if(waiter.getId() == null){
            // 初始化属性
            waiter.setStatus("正常");
            waiterMapper.insert(waiter);
        } else {
            waiterMapper.updateByPrimaryKey(waiter);
        }
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
    /**
     * 批量删除
     * @param ids
     * @throws Exception
     */
    @Override
    public void batchDelete(long[] ids) throws Exception {
        for(long id :ids){
            waiterMapper.deleteByPrimaryKey(id);
        }
    }
}
