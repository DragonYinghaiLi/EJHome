package com.okami.apps.ej.web.controller;


import com.okami.apps.ej.bean.Waiter;
import com.okami.apps.ej.service.IWaiterService;
import com.okami.apps.ej.utils.Message;
import com.okami.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;


@RestController
@RequestMapping("/waiter")
public class WaiterController {
@Autowired
    private IWaiterService waiterService;
    @GetMapping("findAll")
    @ApiOperation("查询服务员信息")
    public Message findAll(){
        List<Waiter> list=waiterService.findAll();
        return MessageUtil.success("success",list);
    }

    @ApiOperation("通过id查询服务员信息")
    @GetMapping("findById")
    public  Message findById(@ApiParam(value = "主键",required =true)@RequestParam(value ="id") long id){
        List<Waiter> list= (List<Waiter>) waiterService.findById(id);
        return MessageUtil.success("查询成功",list);

    }
    @ApiOperation("模糊查询")
    @GetMapping("query")
    public Message query(Waiter waiter){
        List<Waiter> list=waiterService.query(waiter);
        return MessageUtil.success("success",list);
    }
    @GetMapping("deleteById")
    @ApiOperation("通过id删除服务员信息")
    public String deleteById(@ApiParam(value = "主键",required = true)@RequestParam("id")long id){
        try{
            waiterService.deleteById(id);
            return "删除成功";
        }catch(Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @GetMapping("saveOrUpdate")
    @ApiOperation("保存或更新服务员信息")
    public Message saveOrUpdate(Waiter waiter){
        try {
            waiterService.saveOrUpdate(waiter);
            return MessageUtil.success("保存成功!");
        }catch (Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
    @PostMapping("batchDelete")
    @ApiOperation("批量删除服务员信息")
    public Message batchDelete(@NotNull(message = "ids不能为空") long[] ids) throws Exception{
        waiterService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
}
