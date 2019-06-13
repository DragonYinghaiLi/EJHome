package com.okami.apps.ej.web.controller;

import com.okami.apps.ej.bean.OrderLine;
import com.okami.apps.ej.service.IOrderLineService;
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
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderLineService orderlineService;

    @GetMapping("findAll")
    @ApiOperation("查询其他信息")
    public Message findAll(){
        List<OrderLine> list=orderlineService.findAll();
        return MessageUtil.success("success",list);
    }

    @GetMapping("deleteById")
    @ApiOperation("通过id删除其他信息")
    public String deleteById(@ApiParam(value = "主键",required = true)@RequestParam("id")long id){
        try{
            orderlineService.deleteById(id);
            return "删除成功";
        }catch(Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
