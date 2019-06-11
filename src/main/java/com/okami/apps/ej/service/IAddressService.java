package com.okami.apps.ej.service;

import com.okami.apps.ej.bean.Address;

import java.util.List;

public interface IAddressService {
    List<Address> findAll();
    void deleteById(long id) throws Exception;
}
