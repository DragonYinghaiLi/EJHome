package com.okami.apps.ej.service;

import com.okami.apps.ej.bean.Product;

import java.util.List;

/***
 * 产品
 */
public interface IProductService {
    List<Product> findAll();

    Product findById(long id);
    List<Product> query(Product waiter);
    void deleteById(long id) throws Exception;
    void saveOrUpdate(Product product) throws Exception;
    void batchDelete(long[] ids) throws Exception;
}
