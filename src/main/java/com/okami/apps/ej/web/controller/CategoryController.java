package com.okami.apps.ej.web.controller;


import com.okami.apps.ej.bean.Category;
import com.okami.apps.ej.service.ICategoryService;
import com.okami.apps.ej.utils.Message;
import com.okami.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/***
 * 分类管理控制器
 */
@Api(description = "分类管理相关接口")
@Validated
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @ApiOperation("查询所有分类信息")
    @GetMapping("findAllCategory")
    public Message findCategoryAll() {
        List<Category> list = categoryService.findAllCategory();
        return MessageUtil.success("message", list);
    }

    @ApiOperation("根据Id查找分类信息")
    @GetMapping("findByCategoryId")
    public Message findByCategoryId(@ApiParam(value = "主键",required =true)@RequestParam(value ="id")long id) {
        Category category = categoryService.findCategoryById(id);
        return MessageUtil.success("success", category);
    }

    @ApiOperation("根据Id删除分类信息")
    @GetMapping("deleteByCategoryId")
    public Message deleteByCategoryId(@NotNull @RequestParam("id") long id) throws Exception {
        categoryService.deleteCategoryById(id);
        return MessageUtil.success("删除分类成功！");
    }
    @ApiOperation("增加分类")
    @PostMapping("insertCategory")
    public Message insertCategory(@Validated@ModelAttribute Category category) throws Exception {
        categoryService.insertCategory(category);
        return MessageUtil.success("增加新的分类成功!");
    }

    @ApiOperation("根据id修改分类")
    @PostMapping("updateCategory")
    public Message updateCategory(@Validated@ModelAttribute Category category) throws Exception {
        categoryService.updateCategoryPrimaryKey(category);
        return MessageUtil.success("修改分类成功！");
    }
    @PostMapping("batchDeleteCategory")
    @ApiOperation("批量删除分类信息")
    public Message batchDeleteCategory(long[] ids) throws Exception{
        categoryService.batchDeleteCategory(ids);
        return MessageUtil.success("批量删除成功");
    }
}
