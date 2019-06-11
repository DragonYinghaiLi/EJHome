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
    @GetMapping("save")
    @ApiOperation("添加服务员信息")
    public  String save(Waiter waiter){
        try{
            waiterService.save(waiter);
            return "添加成功";
        }catch(Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
    @GetMapping("update")
    @ApiOperation("修改服务员信息")
    public String update(Waiter waiter){
        try{
            waiterService.update(waiter);
            return "修改成功";
        }catch(Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
    @PostMapping("batchDelete")
    @ApiOperation("批量删除服务员信息")
    public Message batchDelete(@NotNull(message = "ids不能为空") long[] ids) throws Exception{
        waiterService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
}
