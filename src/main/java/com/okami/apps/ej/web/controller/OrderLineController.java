package com.okami.apps.ej.web.controller;


import com.okami.apps.ej.bean.OrderLine;
import com.okami.apps.ej.service.IOrderLineService;
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
@Api(description = "订单项管理相关接口")
@Validated
@RestController
@RequestMapping("/orderline")
public class OrderLineController {

    @Autowired
    private IOrderLineService orderLineService;

    @GetMapping("findAll")
    public Message findAll(){
        List<OrderLine> list = orderLineService.findAll();
        return MessageUtil.success("success",list);
    }
    @ApiOperation("通过id查询订单项信息")
    @GetMapping("findById")
    public  Message findById(@ApiParam(value = "主键",required =true)@RequestParam(value ="id") long id){
        List<OrderLine> list= (List<OrderLine>) orderLineService.findById(id);
        return MessageUtil.success("查询成功",list);
    }
    @ApiOperation("模糊查询")
    @GetMapping("query")
    public Message query(OrderLine orderLine){
        List<OrderLine> list=orderLineService.query(orderLine);
        return MessageUtil.success("success",list);
    }
    @GetMapping("deleteById")
    @ApiOperation("通过id删除订单项信息")
    public String deleteById(@ApiParam(value = "主键",required = true)@RequestParam("id")long id){
        try{
            orderLineService.deleteById(id);
            return "删除成功";
        }catch(Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
    @ApiOperation("保存或更新订单项信息")
    @GetMapping("saveOrUpdate")
    public Message saveOrUpdate(OrderLine orderLine){
        try {
            orderLineService.saveOrUpdate(orderLine);
            return MessageUtil.success("保存成功!");
        }catch (Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
    @PostMapping("batchDelete")
    @ApiOperation("批量删除订单项信息")
    public Message batchDelete(@NotNull(message = "ids不能为空") long[] ids) throws Exception{
        orderLineService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }}
