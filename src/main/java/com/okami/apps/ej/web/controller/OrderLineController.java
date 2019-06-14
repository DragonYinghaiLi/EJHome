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
/***
 * 订单项控制器
 */
@Validated
@RestController
@RequestMapping("/orderLine")
@Api(description = "订单项管理相关接口")
public class OrderLineController {
    @Autowired
    private IOrderLineService orderLineService;

    @ApiOperation("查询所有订单项信息")
    @GetMapping("findAllOrderLine")
    public Message findAllOrderLine(){
        List<OrderLine> list = orderLineService.findAllOrderLine();
        return MessageUtil.success("success",list);
    }

    @ApiOperation("通过id查询订单项信息")
    @GetMapping("findOrderLineById")
    public Message findOrderLineById(@ApiParam(required = true) @RequestParam(value = "id") @NotNull long id){
        OrderLine orderLine = orderLineService.findOrderLineById(id);
        return MessageUtil.success("success",orderLine);
    }

    @ApiOperation("模糊查询订单项信息")
    @GetMapping("query")
    public Message query(OrderLine orderLine){
        List<OrderLine> list = orderLineService.query(orderLine);
        return MessageUtil.success("success",list);
    }

    @ApiOperation("增加订单项")
    @PostMapping("insertOrderLine")
    public Message insertOrderLine(@Validated@ModelAttribute OrderLine orderLine) throws Exception {
        orderLineService.insertOrderLine(orderLine);
        return MessageUtil.success("增加新的订单项成功!");
    }

    @ApiOperation("根据id修改订单项")
    @PostMapping("updateOrderLinePrimaryKey")
    public Message updateOrderLinePrimaryKey(@Validated@ModelAttribute OrderLine orderLine) throws Exception {
        orderLineService.updateOrderLinePrimaryKey(orderLine);
        return MessageUtil.success("修改订单项成功！");
    }

    @ApiOperation("通过id删除订单项信息")
    @PostMapping("deleteOrderLineById")
    public Message deleteOrderLineById(@ApiParam(value = "主键",required = true) @RequestParam("id") @NotNull long id){
        try {
            orderLineService.deleteOrderLineById(id);
            return MessageUtil.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
    @PostMapping("batchDeleteOrderLine")
    @ApiOperation("批量删除顾客信息")
    public Message batchDeleteOrderLine(long[] ids) throws Exception{
        orderLineService.batchDeleteOrderLine(ids);
        return MessageUtil.success("批量删除成功");
    }
}