package com.okami.apps.ej.service;

import com.okami.apps.ej.bean.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void deleteById(long id) throws Exception;
}
