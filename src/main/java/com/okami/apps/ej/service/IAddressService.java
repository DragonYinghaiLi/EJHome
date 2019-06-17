package com.okami.apps.ej.service;

import com.okami.apps.ej.bean.Address;

import java.util.List;

/***
 * 地址接口
 */
public interface IAddressService {
    //查看所有地址
    List<Address> findAll();
    //根据id插入地址
    Address findById(long id);
    //根据id删除地址
    void deleteById(long id) throws Exception;
    //插入新的分类
    void insert(Address address)throws Exception;
    //修改分类
    void updatePrimaryKey(Address address)throws Exception;
    //批量删除
    void batchDelete(long[] ids) throws Exception;
}
