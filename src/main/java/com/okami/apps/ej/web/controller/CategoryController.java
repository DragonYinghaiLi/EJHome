package com.okami.apps.ej.web.controller;


import com.okami.apps.ej.bean.Category;
import com.okami.apps.ej.service.ICategoryService;
import com.okami.apps.ej.utils.Message;
import com.okami.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;
    @GetMapping("findAll")
    @ApiOperation("查询信息")
    public Message findAll(){
        List<Category> list=categoryService.findAll();
        return MessageUtil.success("success",list);
    }
    @ApiOperation("通过id查询用户信息")
    @GetMapping("findById")
    public  Message findById(@ApiParam(value = "主键",required =true)@RequestParam(value ="id") long id){
        List<Category> list= (List<Category>) categoryService.findById(id);
        return MessageUtil.success("查询成功",list);

    }

    @ApiOperation("模糊查询")
    @GetMapping("query")
    public Message query(Category category){
        List<Category> list=categoryService.query(category);
        return MessageUtil.success("success",list);
    }
    @GetMapping("deleteById")
    @ApiOperation("通过id删除服务员信息")
    public Message deleteById(@ApiParam(value = "主键",required = true)@RequestParam("id")long id) throws  Exception{
        categoryService.deleteById(id);
        return MessageUtil.success("删除成功") ;
    }
    @ApiOperation("保存或更新顾客信息")
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Category address){
        try {
            categoryService.saveOrUpdate(address);
            return MessageUtil.success("保存成功!");
        }catch (Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
    @PostMapping("batchDelete")
    @ApiOperation("批量删除服务员信息")
    public Message batchDelete(@NotNull(message = "ids不能为空") long[] ids) throws Exception{
        categoryService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
}
