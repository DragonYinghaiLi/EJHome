package com.okami.apps.ej.web.controller;

import com.okami.apps.ej.bean.Customer;
import com.okami.apps.ej.service.ICustomerService;
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


@Api(description = "顾客管理相关接口")
@Validated
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @ApiOperation("模糊查询")
    @GetMapping("query")
    public Message query(Customer customer){
        List<Customer> list=customerService.query(customer);
        return MessageUtil.success("success",list);
    }
    @GetMapping("findAll")
    @ApiOperation("查询所有顾客信息")
    public Message findAll(){
        List<Customer> list=customerService.findAll();
        return MessageUtil.success("success",list);
    }
    @ApiOperation("通过id查询顾客信息")
    @GetMapping("findById")
    public  Message findById(@ApiParam(value = "主键",required =true)@RequestParam(value ="id") long id){
        List<Customer> list= (List<Customer>) customerService.findById(id);
        return MessageUtil.success("查询成功",list);

    }

    @PostMapping("saveOrUpdate")
    @ApiOperation("保存或者更新顾客信息")
    public Message saveOrUpdate(Customer customer) throws Exception{
        customerService.saveOrUpdate(customer);
        return MessageUtil.success("操作成功");
    }

    @GetMapping("deleteById")
    @ApiOperation("通过id删除顾客信息")
    public String deleteById(@ApiParam(value = "主键",required = true)@RequestParam("id")long id) throws Exception{
        try{
            customerService.deleteById(id);
            return "删除成功";
        }catch(Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
    @PostMapping("batchDelete")
    @ApiOperation("批量删除顾客信息")
    public Message batchDelete(@NotNull(message = "ids不能为空") long[] ids) throws Exception{
        customerService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
}
