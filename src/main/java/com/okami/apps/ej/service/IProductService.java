package com.okami.apps.ej.service;

import com.okami.apps.ej.bean.Product;
import com.okami.apps.ej.bean.extend.ProductExtend;

import java.util.List;

/***
 * 产品
 */
public interface IProductService {

    List<ProductExtend> findAllWithCategory();

    List<Product> findAll();
    Product findById(long id);
    List<Product> query(Product product);
    void deleteById(long id) throws Exception;
    void saveOrUpdate(Product product) throws Exception;
    void batchDelete(long[] ids) throws Exception;
}
