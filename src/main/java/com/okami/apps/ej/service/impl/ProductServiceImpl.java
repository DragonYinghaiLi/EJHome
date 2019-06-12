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


    @Override
    public Product findById(long id) {
        //调用dao层代码完成操作
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Product> query(Product product){
        return productMapper.query(product);
    }
    @Override
    public void saveOrUpdate(Product product) throws Exception {
        if (product.getId() == null) {
            productMapper.insert(product);
        } else {
            productMapper.updateByPrimaryKey(product);
        }
    }



    @Override
    public void deleteById(long id) throws Exception {
        Product product=productMapper.selectByPrimaryKey(id);
        if(product==null){
            throw  new Exception("要删除不存在");
        }else{
            productMapper.deleteByPrimaryKey(id);
        }
    }
    @Override
    public void batchDelete(long[] ids) throws Exception {
        for(long id :ids){
            productMapper.deleteByPrimaryKey(id);
        }
    }
}
