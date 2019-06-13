package com.okami.apps.ej.web.controller;

import com.okami.apps.ej.bean.Customer;
import com.okami.apps.ej.service.ICustomerService;
import com.okami.apps.ej.utils.Message;
import com.okami.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/***
 * 顾客管理控制类
 */
@Validated
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("findCustomerAll")
    @ApiOperation("查询所有顾客信息")
    public Message findCustomerAll(){
        List<Customer> list=customerService.findCustomerAll();
        return MessageUtil.success("success",list);
    }
    @ApiOperation("通过id查询用户信息")
    @GetMapping("findCustomerById")
    public  Message findCustomerById(@ApiParam(value = "主键",required =true)@RequestParam(value ="id") long id){
        List<Customer> list= (List<Customer>) customerService.findCustomerById(id);
        return MessageUtil.success("查询成功",list);

    }
    @ApiOperation("模糊查询")
    @GetMapping("queryCustomer")
    public Message queryCustomer(Customer customer){
        List<Customer> list=customerService.queryCustomer(customer);
        return MessageUtil.success("success",list);
    }
    @PostMapping("saveCustomerOrUpdateCustomer")
    @ApiOperation("添加修改顾客信息")
    public Message saveCustomerOrUpdateCustomer(@Validated@ModelAttribute Customer customer) throws  Exception{
        customerService.saveCustomerOrUpdateCustomer(customer);
        return MessageUtil.success("修改成功");
    }

    @GetMapping("deleteCustomerById")
    @ApiOperation("通过id删除顾客信息")
    public Message deleteCustomerById(@NotNull @RequestParam("id")long id) throws Exception {

            customerService.deleteCustomerById(id);
            return MessageUtil.success("删除成功");
    }


    @PostMapping("batchDeleteCustomer")
    @ApiOperation("批量删除顾客信息")
    public Message batchDeleteCustomer(long[] ids) throws Exception{
        customerService.batchDeleteCustomer(ids);
        return MessageUtil.success("批量删除成功");
    }
}
