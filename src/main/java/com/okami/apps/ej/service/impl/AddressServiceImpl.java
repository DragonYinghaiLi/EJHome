package com.okami.apps.ej.service.impl;

import com.okami.apps.ej.bean.Address;
import com.okami.apps.ej.bean.AddressExample;
import com.okami.apps.ej.dao.AddressMapper;
import com.okami.apps.ej.service.IAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService {
    @Resource
    private AddressMapper addressMapper;
    @Override
    public List<Address> findAll(){
        AddressExample example=new AddressExample();
        return addressMapper.selectByExample(example);
    }
    @Override
    public void deleteById(long id) throws Exception{
        Address address=addressMapper.selectByPrimaryKey(id);
        if (address==null){
            throw new Exception("删除的地址内容不存在");
        }else{
            addressMapper.deleteByPrimaryKey(id);
        }
    }
}