package com.okami.apps.ej.web.controller;


import com.okami.apps.ej.bean.Order;
import com.okami.apps.ej.bean.extend.OrderExtend;
import com.okami.apps.ej.bean.vm.OrderAndOrderLineVM;
import com.okami.apps.ej.bean.vm.OrderVM;
import com.okami.apps.ej.service.IOrderService;
import com.okami.apps.ej.utils.Message;
import com.okami.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
@Api(description = "评论管理相关接口")
@Validated
@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private IOrderService orderService;

    @GetMapping("queryBasic")
    @ApiOperation("查询订单信息，返回列表数据")
    public Message queryBasic(Long customerId,Long waiterId){
        List<OrderVM> list = orderService.queryBasic(customerId,waiterId);
        return MessageUtil.success("success",list);
    }

    @GetMapping("query")
    @ApiOperation("查询订单信息，并且订单级联关键的属性")
    public Message query(Long customerId,Long waiterId){
        List<OrderExtend> list = orderService.query(customerId,waiterId);
        return MessageUtil.success("success",list);
    }

    @GetMapping("findAll")
    @ApiOperation("查询所有订单信息")
    public Message findAll(){
        List<Order> list = orderService.findAll();
        return MessageUtil.success("success",list);
    }

    @PostMapping("save")
    @ApiOperation("保存订单信息")
    public Message saveOrUpdate(@Valid @ModelAttribute OrderAndOrderLineVM order) throws Exception{
        orderService.save(order);
        return MessageUtil.success("操作成功");
    }

    @GetMapping("deleteById")
    @ApiOperation("通过ID删除订单")
    public Message deleteById(@NotNull @RequestParam("id") Long id) throws Exception{
        orderService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @PostMapping("batchDelete")
    @ApiOperation("批量删除订单信息")
    public Message batchDelete(long[] ids) throws Exception{
        orderService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
}
