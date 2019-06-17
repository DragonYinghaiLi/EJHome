package com.okami.apps.ej.service;

import com.okami.apps.ej.bean.Address;

import java.util.List;

/***
 * 地址接口
 */
public interface IAddressService {
    //查看所有地址
    List<Address> findAddressAll();
    //根据id插入地址
    Address findAddressById(long id);
    //根据id删除地址
    void deleteAddressById(long id) throws Exception;
    //插入新的分类
    void insertAddress(Address address)throws Exception;
    //修改分类
    void updateAddressPrimaryKey(Address address)throws Exception;
    //批量删除
    void batchDeleteAddress(long[] ids) throws Exception;
}
