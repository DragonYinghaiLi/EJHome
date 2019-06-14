package com.okami.apps.ej.web.controller;

import com.okami.apps.ej.bean.Waiter;
import com.okami.apps.ej.service.IWaiterService;
import com.okami.apps.ej.utils.Message;
import com.okami.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/waiter")
@Api("服务员管理控制器")
public class WaiterController {
    @Autowired
    private IWaiterService waiterService;

    @GetMapping("findAll")
    @ApiOperation("查询顾客信息")
    public Message findAll(){
        List<Waiter> list=waiterService.findAll();
        return MessageUtil.success("success",list);
    }

    @GetMapping("deleteById")
    @ApiOperation("通过id删除顾客信息")
    public String deleteById(@ApiParam(value = "主键",required = true)@RequestParam("id")long id){
        try{
            waiterService.deleteById(id);
            return "删除成功";
        }catch(Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
