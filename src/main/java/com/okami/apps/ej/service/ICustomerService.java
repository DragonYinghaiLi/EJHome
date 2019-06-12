package com.okami.apps.ej.service;

import com.okami.apps.ej.bean.Customer;

import java.util.List;

/***
 * 顾客管理
 */
public interface ICustomerService {
    List<Customer> findAll();
    List<Customer> query(Customer customer);
    Customer findById(long id);
    void deleteById(long id) throws Exception;
    void saveOrUpdate(Customer customer) throws Exception;
    void batchDelete(long[] ids) throws Exception;
}
