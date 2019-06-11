package com.okami.apps.ej.service;

import com.okami.apps.ej.bean.Customer;

import java.util.List;

/***
 * 顾客管理
 */
public interface ICustomerService {
    List<Customer> findAll();
    void deleteById(long id) throws Exception;
    void save(Customer customer) throws Exception;
    void update(Customer customer) throws Exception;

}
