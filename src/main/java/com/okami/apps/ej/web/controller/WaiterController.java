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

    @ApiOperation("通过id查询用户信息")
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
    public Message deleteById(@ApiParam(value = "主键",required = true)@RequestParam("id")long id) throws  Exception{
            waiterService.deleteById(id);
            return MessageUtil.success("删除成功") ;
    }
    @GetMapping("save")
    @ApiOperation("添加服务员信息")
    public  Message save(Waiter waiter) throws  Exception{
            waiterService.save(waiter);
            return MessageUtil.success ("添加成功");
    }

    @GetMapping("update")
    @ApiOperation("修改服务员信息")
    public Message update(Waiter waiter) throws  Exception{
            waiterService.update(waiter);
            return MessageUtil.success ("修改成功");
    }
    @PostMapping("batchDelete")
    @ApiOperation("批量删除服务员信息")
    public Message batchDelete(@NotNull(message = "ids不能为空") long[] ids) throws Exception{
        waiterService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
}
