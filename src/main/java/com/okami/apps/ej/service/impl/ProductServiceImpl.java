package com.okami.apps.ej.service.impl;

import com.okami.apps.ej.bean.Product;
import com.okami.apps.ej.bean.ProductExample;
import com.okami.apps.ej.dao.ProductMapper;
import com.okami.apps.ej.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * 产品实现类
 */
@Service
public class ProductServiceImpl  implements IProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> findAll() {
        ProductExample example = new ProductExample();
        return productMapper.selectByExample(example);
    }

}
