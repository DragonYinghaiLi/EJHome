package com.okami.apps.ej.service;

import com.okami.apps.ej.bean.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
}
