package com.okami.apps.ej.service;

import com.okami.apps.ej.bean.Address;


import java.util.List;

public interface IAddressService {

    List<Address> findAll();
    Address findById(long id);
    List<Address> query(Address address);
    void deleteById(long id) throws Exception;
    void saveOrUpdate(Address address) throws Exception;
    void batchDelete(long[] ids) throws Exception;
}
