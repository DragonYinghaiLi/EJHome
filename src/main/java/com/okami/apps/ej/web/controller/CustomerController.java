package com.okami.apps.ej.web.controller;

import com.okami.apps.ej.bean.Customer;
import com.okami.apps.ej.service.ICustomerService;
import com.okami.apps.ej.utils.Message;
import com.okami.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("findAll")
    @ApiOperation("查询顾客信息")
    public Message findAll(){
        List<Customer> list=customerService.findAll();
        return MessageUtil.success("success",list);
    }

    @GetMapping("deleteById")
    @ApiOperation("通过id删除顾客信息")
    public String deleteById(@ApiParam(value = "主键",required = true)@RequestParam("id")long id){
        try{
            customerService.deleteById(id);
            return "删除成功";
        }catch(Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
    @GetMapping("save")
    @ApiOperation("添加信息")
    public  String save(Customer customer){
        try{
            customerService.save(customer);
            return "添加成功";
        }catch(Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
    @GetMapping("update")
    @ApiOperation("修改顾客信息")
    public String update(Customer customer){
        try{
            customerService.update(customer);
            return "修改成功";
        }catch(Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }


}
