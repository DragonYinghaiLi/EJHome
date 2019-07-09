package com.okami.apps.ej.service;

import com.okami.apps.ej.bean.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(long id);
    List<Category> query(Category category);
    void deleteById(long id) throws Exception;
    void saveOrUpdate(Category category) throws Exception;
    void batchDelete(long[] ids) throws Exception;
}
