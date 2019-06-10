package com.okami.apps.ej.service.impl;

import com.okami.apps.ej.bean.Customer;
import com.okami.apps.ej.dao.CustomerMapper;
import com.okami.apps.ej.service.ICustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
 @Resource
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> findAll() {
        return null;
    }
}
