package com.okami.apps.ej.service.impl;

import com.okami.apps.ej.bean.Address;
import com.okami.apps.ej.bean.AddressExample;
import com.okami.apps.ej.bean.extend.AddressExtend;
import com.okami.apps.ej.dao.AddressMapper;
import com.okami.apps.ej.dao.extend.AddressExtendMapper;
import com.okami.apps.ej.service.IAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/***
 * 收货地址接口方法实现
 */
@Service
public class AddressServiceImpl implements IAddressService {
    @Resource
    private AddressMapper addressMapper;
    @Resource
    private AddressExtendMapper addressExtendMapper;

    @Override
    public List<AddressExtend> query(Long customerId) {
        return addressExtendMapper.query(customerId);
    }
    @Override
    public List<AddressExtend> queryBasic(Long categoryId) {
        return addressExtendMapper.query(categoryId);
    }
    /**
     * 查看所有地址
     * @return
     */
    @Override
    public List<Address> findAddressAll() {
        AddressExample example=new AddressExample();
        return addressMapper.selectByExample(example);
    }

    /**
     * 通过id查询地址
     * @param id
     * @return
     */
    @Override
    public Address findAddressById(long id) {
        //调用dao层代码完成操作
        return addressMapper.selectByPrimaryKey(id);
    }
    /***
     * 添加收货地址
     * @param address
     * @throws Exception
     */

    @Override
    public void insertAddress(Address address) throws Exception {
        Address address1=addressMapper.selectByPrimaryKey(address.getId());
        if(address1==null){
            addressMapper.insert(address);
        }else{
            throw new Exception("Id已存在");
        }

    }
    /***
     * 修改
     * @param category
     * @throws Exception
     */
    @Override
    public void updateAddressPrimaryKey(Address category) throws Exception {
        Address category1=addressMapper.selectByPrimaryKey(category.getId());
        if(category1==null){
            throw new Exception("要修改的分类不存在！");
        }else{
            addressMapper.updateByPrimaryKeySelective(category);
        }
    }
    /***
     * 删除
     * @param id
     * @throws Exception
     */
    @Override
    public void deleteAddressById(long id) throws Exception {
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
    public void batchDeleteAddress(long[] ids) throws Exception {
        for(long id :ids){
            addressMapper.deleteByPrimaryKey(id);
        }
    }
}
