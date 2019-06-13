package com.okami.apps.ej.web.controller;

import com.okami.apps.ej.bean.Product;
import com.okami.apps.ej.service.IProductService;
import com.okami.apps.ej.utils.Message;
import com.okami.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 产品控制类
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("findAll")
    public Message findAll(){
        List<Product> list = productService.findAll();
        return MessageUtil.success("success",list);
    }
    @ApiOperation("通过id查询用户信息")
    @GetMapping("findById")
    public  Message findById(@ApiParam(value = "主键",required =true)@RequestParam(value ="id") long id){
        List<Product> list= (List<Product>) productService.findById(id);
        return MessageUtil.success("查询成功",list);
    }
    @ApiOperation("模糊查询")
    @GetMapping("query")
    public Message query(Product product){
        List<Product> list=productService.query(product);
        return MessageUtil.success("success",list);
    }
    @GetMapping("deleteById")
    @ApiOperation("通过id删除顾客信息")
    public String deleteById(@ApiParam(value = "主键",required = true)@RequestParam("id")long id){
        try{
            productService.deleteById(id);
            return "删除成功";
        }catch(Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
    @ApiOperation("保存或更新顾客信息")
    @GetMapping("saveOrUpdate")
    public Message saveOrUpdate(Product product){
        try {
            productService.saveOrUpdate(product);
            return MessageUtil.success("保存成功!");
        }catch (Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
    @PostMapping("batchDelete")
    @ApiOperation("批量删除服务员信息")
    public Message batchDelete(@NotNull(message = "ids不能为空") long[] ids) throws Exception{
        productService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
}
