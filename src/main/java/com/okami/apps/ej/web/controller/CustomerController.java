package com.okami.apps.ej.web.controller;

import com.okami.apps.ej.bean.Customer;
import com.okami.apps.ej.service.ICustomerService;
import com.okami.apps.ej.utils.Message;
import com.okami.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("findAll")
    @ApiOperation("查询所有顾客信息")
    public Message findAll(){
        List<Customer> list=customerService.findAll();
        return MessageUtil.success("success",list);
    }
    @ApiOperation("通过id查询用户信息")
    @GetMapping("findById")
    public  Message findById(@ApiParam(value = "主键",required =true)@RequestParam(value ="id") long id){
        List<Customer> list= (List<Customer>) customerService.findById(id);
        return MessageUtil.success("查询成功",list);

    }
    @ApiOperation("模糊查询")
    @GetMapping("query")
    public Message query(Customer customer){
        List<Customer> list=customerService.query(customer);
        return MessageUtil.success("success",list);
    }



    @GetMapping("deleteById")
    @ApiOperation("通过id删除顾客信息")
    public Message deleteById(@ApiParam(value = "主键",required = true)@RequestParam("id")long id) throws Exception {
            customerService.deleteById(id);
            return MessageUtil.success("删除成功");
    }
    @GetMapping("save")
    @ApiOperation("添加信息")
    public  Message save(Customer customer) throws Exception{
        if (customer.getId()==null){
            customerService.save(customer);
            return MessageUtil.success("添加成功");
        }else{
            return MessageUtil.success("id已存在");
        }


    }
    @GetMapping("update")
    @ApiOperation("修改顾客信息")
    public Message update(Customer customer) throws  Exception{
            customerService.update(customer);
            return MessageUtil.success("修改成功");
    }
    @PostMapping("batchDelete")
    @ApiOperation("批量删除顾客信息")
    public Message batchDelete(@NotNull(message = "ids不能为空") long[] ids) throws Exception{
        customerService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
}
