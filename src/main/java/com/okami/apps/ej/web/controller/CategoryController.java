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
    @GetMapping("findAll")
    public Message findAll() {
        List<Category> list = categoryService.findAll();
        return MessageUtil.success("message", list);
    }

    @ApiOperation("根据Id查找分类信息")
    @GetMapping("findById")
    public Message findById(@ApiParam(value = "主键",required =true)@RequestParam(value ="id")long id) {
        Category category = categoryService.findById(id);
        return MessageUtil.success("success", category);
    }

    @ApiOperation("根据Id删除分类信息")
    @PostMapping("deleteById")
    public Message deleteById(@NotNull @RequestParam("id") long id) throws Exception {
        categoryService.deleteById(id);
        return MessageUtil.success("删除分类成功！");
    }
    @ApiOperation("增加分类")
    @PostMapping("insert")
    public Message insert(@Validated@ModelAttribute Category category) throws Exception {
        categoryService.insert(category);
        return MessageUtil.success("增加新的分类成功!");
    }

    @ApiOperation("根据id修改分类")
    @PostMapping("update")
    public Message update(@Validated@ModelAttribute Category category) throws Exception {
        categoryService.updatePrimaryKey(category);
        return MessageUtil.success("修改分类成功！");
    }
    @PostMapping("batchDelete")
    @ApiOperation("批量删除分类信息")
    public Message batchDelete(long[] ids) throws Exception{
        categoryService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
}
