package com.okami.apps.ej.web.controller;


import com.okami.apps.ej.bean.Address;
import com.okami.apps.ej.bean.extend.AddressExtend;
import com.okami.apps.ej.service.IAddressService;
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
@Api(description = "地址管理相关接口")
@Validated
@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private IAddressService addressService;


    @ApiOperation("查询顾客的地址")
    @GetMapping("findAllWithCustomer")
    public Message findAllWithCustomer(){
        List<AddressExtend> list = addressService.findAllWithCustomer();
        return MessageUtil.success("success",list);
    }


    @GetMapping("findAll")
    @ApiOperation("查询地址信息")
    public Message findAll(){
        List<Address> list=addressService.findAll();
        return MessageUtil.success("success",list);
    }
    @ApiOperation("通过id查询地址信息")
    @GetMapping("findById")
    public  Message findById(@ApiParam(value = "主键",required =true)@RequestParam(value ="id") long id){
        List<Address> list= (List<Address>) addressService.findById(id);
        return MessageUtil.success("查询成功",list);

    }

    @ApiOperation("模糊查询")
    @GetMapping("query")
    public Message query(Address address){
        List<Address> list=addressService.query(address);
        return MessageUtil.success("success",list);
    }
    @GetMapping("deleteById")
    @ApiOperation("通过id删除地址信息")
    public Message deleteById(@ApiParam(value = "主键",required = true)@RequestParam("id")long id) throws  Exception{
        addressService.deleteById(id);
        return MessageUtil.success("删除成功") ;
    }
    @ApiOperation("保存或更新地址信息")
    @GetMapping("saveOrUpdate")
    public Message saveOrUpdate(Address address){
        try {
            addressService.saveOrUpdate(address);
            return MessageUtil.success("保存成功!");
        }catch (Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
    @PostMapping("batchDelete")
    @ApiOperation("批量删除地址信息")
    public Message batchDelete(@NotNull(message = "ids不能为空") long[] ids) throws Exception{
        addressService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
}
