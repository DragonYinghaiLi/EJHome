package com.okami.apps.ej.web.controller;

import com.okami.apps.ej.bean.Address;
import com.okami.apps.ej.service.IAddressService;
import com.okami.apps.ej.utils.Message;
import com.okami.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private IAddressService addressService;
    @GetMapping("findAll")
    @ApiOperation("查询地址信息")
    public Message findAll(){
        List<Address> list=addressService.findAll();
        return MessageUtil.success("success",list);
    }

    @ApiOperation("通过id查询用户信息")
    @GetMapping("findById")
    public  Message findById(@ApiParam(value = "主键",required =true)@RequestParam(value ="id") long id){
        List<Address> list= (List<Address>) addressService.findById(id);
        return MessageUtil.success("查询成功",list);

    }

    @GetMapping("deleteById")
    @ApiOperation("通过id删除地址信息")
    public Message deleteById(@ApiParam(value = "主键",required = true)@RequestParam("id")long id) throws  Exception{
        addressService.deleteById(id);
        return MessageUtil.success("删除成功") ;
    }
    @PostMapping("saveOrUpdate")
    @ApiOperation("添加修改地址信息")
    public Message update(Address address) throws  Exception{
        addressService.saveOrUpdate(address);
        return MessageUtil.success("修改成功");
    }
    @PostMapping("batchDelete")
    @ApiOperation("批量删除地址信息")
    public Message batchDelete(@NotNull(message = "ids不能为空") long[] ids) throws Exception{
        addressService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
}
