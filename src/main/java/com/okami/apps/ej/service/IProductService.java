package com.okami.apps.ej.service;

import com.okami.apps.ej.bean.Product;

import java.util.List;

/***
 * 产品
 */
public interface IProductService {
    List<Product> findAll();
}
