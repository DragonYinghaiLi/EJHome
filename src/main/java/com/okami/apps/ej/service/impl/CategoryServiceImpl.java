package com.okami.apps.ej.service.impl;

import com.okami.apps.ej.bean.Category;
import com.okami.apps.ej.bean.CategoryExample;
import com.okami.apps.ej.dao.CategoryMapper;
import com.okami.apps.ej.service.ICategoryService;
import org.springframework.stereotype.Service;

/***
 * 分类管理
 */
import javax.annotation.Resource;
import java.util.List;
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    /***
     * 查询全部
     * @return
     */
    @Override
    public List<Category> findAllCategory() {
        CategoryExample example=new CategoryExample();
        return categoryMapper.selectByExample(example);
    }

    /***
     * 根据id查询分类
     * @param id
     * @return
     */
    @Override
    public Category findCategoryById(long id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    /***
     * 根据id删除
     * @param id
     * @throws Exception
     */
    @Override
    public void deleteCategoryById(long id) throws Exception {
        Category category=categoryMapper.selectByPrimaryKey(id);
        if(category==null){
            throw new Exception("删除的分类不存在！");
        }else{
            categoryMapper.deleteByPrimaryKey(id);
        }
    }

    /***
     *插入
     * @param category
     * @throws Exception
     */
    @Override
    public void insertCategory(Category category) throws Exception {
        Category category1=categoryMapper.selectByPrimaryKey(category.getId());
        if(category1==null){
            categoryMapper.insert(category);
        }else{
            throw new Exception("Id已存在");
        }

    }

    /***
     * 修改
     * @param category
     * @throws Exception
     */
    @Override
    public void updateCategoryPrimaryKey(Category category) throws Exception {
        Category category1=categoryMapper.selectByPrimaryKey(category.getId());
        if(category1==null){
            throw new Exception("要修改的分类不存在！");
        }else{
            categoryMapper.updateByPrimaryKeySelective(category);
        }
    }

    /**
     * 批量删除
     * @param ids
     * @throws Exception
     */
    @Override
    public void batchDeleteCategory(long[] ids) throws Exception {
        for(long id :ids){
            categoryMapper.deleteByPrimaryKey(id);
        }
    }
}
