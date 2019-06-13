package com.okami.apps.ej.service;

import com.okami.apps.ej.bean.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    void deleteById(long id) throws Exception;
}
