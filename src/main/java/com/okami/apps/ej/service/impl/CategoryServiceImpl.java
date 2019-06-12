package com.okami.apps.ej.service.impl;

import com.okami.apps.ej.bean.Category;
import com.okami.apps.ej.bean.CategoryExample;
import com.okami.apps.ej.dao.CategoryMapper;
import com.okami.apps.ej.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CategoryServiceImpl implements ICategoryService {

    @Resource
    private CategoryMapper categoryMapper;


    @Override
    public List<Category> findAll() {
        CategoryExample example=new CategoryExample();
        return categoryMapper.selectByExample(example);
    }

    @Override
    public Category findById(long id) {
        //调用dao层代码完成操作
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Category> query(Category category){
        return categoryMapper.query(category);
    }
    @Override
    public void saveOrUpdate(Category category) throws Exception {
        if (category.getId() == null) {
            categoryMapper.insert(category);
        } else {
            categoryMapper.updateByPrimaryKey(category);
        }
    }

    @Override
    public void deleteById(long id) throws Exception {
        Category category=categoryMapper.selectByPrimaryKey(id);
        if(category==null){
            throw  new Exception("要删除服务员不存在");
        }else{
            categoryMapper.deleteByPrimaryKey(id);
        }
    }
    @Override
    public void batchDelete(long[] ids) throws Exception {

        for (long id : ids) {
            categoryMapper.deleteByPrimaryKey(id);
        }
    }


}
