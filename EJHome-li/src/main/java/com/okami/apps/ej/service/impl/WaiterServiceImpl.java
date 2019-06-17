package com.okami.apps.ej.service.impl;

import com.okami.apps.ej.bean.Waiter;
import com.okami.apps.ej.bean.WaiterExample;
import com.okami.apps.ej.dao.WaiterMapper;
import com.okami.apps.ej.service.IWaiterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/***
 * 服务员接口方法实现
 */
@Service
public class WaiterServiceImpl implements IWaiterService {
    @Resource
    private WaiterMapper waiterMapper;

    /**
     * 查询服务员
     * @return
     */
    @Override
    public List<Waiter> findAllWaiter() {
        WaiterExample example=new WaiterExample();
        return waiterMapper.selectByExample(example);
    }

    /**
     * 通过id查询
     * @param id
     * @return
     */
    @Override
    public Waiter findWaiterById(long id) {
        //调用dao层代码完成操作
        return waiterMapper.selectByPrimaryKey(id);
    }

    /**
     * 模糊查询
     * @param waiter
     * @return
     */
    @Override
    public List<Waiter> queryWaiter(Waiter waiter){
        return waiterMapper.query(waiter);
    }
    /**
     * 插入服务员
     * @param waiter
     * @throws Exception
     */
    @Override
    public void insertWaiter(Waiter waiter) throws  Exception{
        waiterMapper.insertSelective(waiter);
    }

    /***
     * 批量插入服务员
     * @param waiter
     * @throws Exception
     */
    @Override
    public void insertBathWaiter(List<Waiter> waiter)  throws  Exception{
        waiterMapper.batchInsert(waiter);
    }

    /***
     * 修改服务员
     * @param waiter
     */
    @Override
    public void updateWaiter(Waiter waiter) {
        waiterMapper.updateByPrimaryKeySelective(waiter);
    }


    /***
     * 删除
     * @param id
     * @throws Exception
     */
    @Override
    public void deleteWaiterById(long id) throws Exception {
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
    public void batchDeleteWaiter(long[] ids) throws Exception {
        for(long id :ids){
            waiterMapper.deleteByPrimaryKey(id);
        }
    }
}
