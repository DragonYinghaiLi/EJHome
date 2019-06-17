package com.okami.apps.ej.service;

import com.okami.apps.ej.bean.Category;

import java.util.List;

/**
 * 产品分类信息接口
 */
public interface ICategoryService {
    //查询所有分类
    List<Category> findAllCategory();

    //根据id查询分类
    Category findCategoryById(long id);

    //根据id删除分类
    void deleteCategoryById(long id) throws Exception;
    //插入新的分类
    void insertCategory(Category category)throws Exception;
    //修改分类
    void updateCategoryPrimaryKey(Category category)throws Exception;
    //批量删除
    void batchDeleteCategory(long[] ids) throws Exception;
}
