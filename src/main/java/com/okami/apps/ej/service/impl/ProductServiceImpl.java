package com.okami.apps.ej.service.impl;


import com.okami.apps.ej.bean.Product;
import com.okami.apps.ej.bean.ProductExample;
import com.okami.apps.ej.dao.ProductMapper;
import com.okami.apps.ej.service.IProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/***
 * 产品实现类
 */
@Service
public class ProductServiceImpl  implements IProductService {

    @Resource
    private ProductMapper productMapper;


    /**
     * 查询所有产品
     * @return
     */
    @Override
    public List<Product> findAllProduct() {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andStatusEqualTo("1");
        List<Product> findAllProductList = productMapper.selectByExample(productExample);
        return findAllProductList;
    }

    /***
     * 分页查询
     * @param currentPage
     * @return
     */
    @Override
    public List<Product> findProductByPage(int currentPage) {
        int rows = 5;
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        int start = (currentPage - 1) * rows;
        criteria.andStatusEqualTo("1");
        //分页查询中的一页数量
        productExample.setPageSize(rows);
        // 开始查询的位置
        productExample.setStartRow(start);
        List<Product> findProductByPageList = productMapper.selectByExample(productExample);
        return findProductByPageList;
    }

    /**
     * 根据id查询产品
     * @param category_id
     * @return
     */
    @Override
    public List<Product> findProductByCategoryId(Long category_id) {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andStatusEqualTo("1").andCategoryIdEqualTo(category_id);
        List<Product> findProductByCategoryIdList = productMapper.selectByExample(productExample);
        return findProductByCategoryIdList;
    }

    /***
     * 根据id删除产品
     * @param id
     * @throws Exception
     */
    @Override
    public void deleteProductById(Long id) throws Exception {
        Product product = productMapper.selectByPrimaryKey(id);
        if (product == null) {
            throw new Exception("要删除的产品不存在");
        } else {
            productMapper.deleteByPrimaryKey(id);
        }
    }

    /***
     * 批量删除产品
     * @param idList
     * @throws Exception
     */
    @Override
    public void deleteBathProduct(List<Long> idList) throws Exception {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andIdIn(idList);
        productMapper.deleteByExample(productExample);

    }

    /**
     * 插入产品
     * @param product
     * @throws Exception
     */
    @Override
    public void insertProduct(Product product) throws  Exception{
        productMapper.insertSelective(product);
    }

    /***
     * 批量插入产品
     * @param products
     * @throws Exception
     */
    @Override
    public void insertBathProduct(List<Product> products)  throws  Exception{
        productMapper.batchInsert(products);
    }

    /***
     * 修改产品
     * @param product
     */
    @Override
    public void updateProduct(Product product) {
        productMapper.updateByPrimaryKeySelective(product);
    }

    /***
     * 批量修改产品
     * @param map
     * @throws Exception
     */
    @Override
    public void updateBatchProductStatus(Map<String, Object> map) throws Exception {
        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andIdIn((List<Long>) map.get("idList"));
        int num = ((List<Long>) map.get("idList")).size();
        int snum = productMapper.selectByExample(productExample).size();
        if (num == snum) {
            productMapper.batchUpdateStatusWithMap(map);
        } else {
            throw new Exception("无效修改，修改产品不存在！");
        }
    }
}