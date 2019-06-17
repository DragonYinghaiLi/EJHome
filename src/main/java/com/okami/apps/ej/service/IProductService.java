package com.okami.apps.ej.service;

import com.okami.apps.ej.bean.Product;

import java.util.List;
import java.util.Map;

/***
 * 产品接口
 */
public interface IProductService {
    //查询所有产品
     List<Product> findAllProduct();

    //根据页号进行分页查询
     List<Product> findProductByPage(int currentPage);

    //模糊查询
    List<Product> queryCustomer(Product product);

    //根据产品名称查询产品信息
    public List<Product> findProductByName(String name)throws Exception;

    //根据分类id查询该分类下的所有产品
     List<Product> findProductByCategoryId(Long category_id);

    //根据商品id删除该商品
     void deleteProductById(Long id)throws Exception;

    //批量删除
     void deleteBathProduct(List<Long> id)throws Exception;

    //添加产品
     void insertProduct(Product product)throws Exception;

    //批量添加产品
      void insertBathProduct(List<Product> products)throws Exception;

    //修改商品的信息
     void updateProduct(Product product)throws Exception;

    //批量修改商品状态
     void updateBatchProductStatus(Map<String,Object> map) throws Exception;
}
