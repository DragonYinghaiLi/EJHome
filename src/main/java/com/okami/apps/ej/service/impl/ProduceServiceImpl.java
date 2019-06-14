package com.okami.apps.ej.service.impl;


import com.okami.apps.ej.bean.Product;
import com.okami.apps.ej.bean.ProductExample;
import com.okami.apps.ej.dao.ProductMapper;
import com.okami.apps.ej.service.IProductService;

import javax.annotation.Resource;
import java.util.List;

public class ProduceServiceImpl  implements IProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public List<Product> findAll() {
        ProductExample example = new ProductExample();
        return productMapper.selectByExample(example);
    }

    @Override
    public void deleteById(long id) throws Exception {
        Product product = productMapper.selectByPrimaryKey(id);
        if (product == null) {
            throw new Exception("要删除产品不存在");
        } else {
            productMapper.deleteByPrimaryKey(id);
        }
    }

}