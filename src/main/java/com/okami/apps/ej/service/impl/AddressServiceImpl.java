package com.okami.apps.ej.service.impl;

import com.okami.apps.ej.bean.Address;
import com.okami.apps.ej.bean.AddressExample;
import com.okami.apps.ej.dao.AddressMapper;
import com.okami.apps.ej.service.IAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/***
 * 收货地址
 */
@Service
public class AddressServiceImpl implements IAddressService {
    @Resource
    private AddressMapper addressMapper;

    @Override
    public List<Address> findAll() {
        AddressExample example=new AddressExample();
        return addressMapper.selectByExample(example);
    }

    /**
     * 通过id查询地址
     * @param id
     * @return
     */
    @Override
    public Address findById(long id) {
        //调用dao层代码完成操作
        return addressMapper.selectByPrimaryKey(id);
    }
    /***
     * 添加服务员
     * @param address
     * @throws Exception
     */
    @Override
    public void saveOrUpdate(Address address) throws Exception{
        if(address.getId() == null){
            // 初始化属性
            addressMapper.insert(address);
        } else {
            addressMapper.updateByPrimaryKey(address);
        }
    }



    /***
     * 删除
     * @param id
     * @throws Exception
     */
    @Override
    public void deleteById(long id) throws Exception {
        Address customer=addressMapper.selectByPrimaryKey(id);
        if(customer==null){
            throw  new Exception("要删除地址不存在");
        }else{
            addressMapper.deleteByPrimaryKey(id);
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
            addressMapper.deleteByPrimaryKey(id);
        }
    }
}
