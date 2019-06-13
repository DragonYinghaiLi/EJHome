package com.okami.apps.ej.web.controller;

import com.okami.apps.ej.bean.Address;
import com.okami.apps.ej.service.IAddressService;
import com.okami.apps.ej.utils.Message;
import com.okami.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/***
 * 地址管理控制器
 */
@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private IAddressService addressService;
    @GetMapping("findAddressAll")
    @ApiOperation("查询地址信息")
    public Message findAddressAll(){
        List<Address> list=addressService.findAddressAll();
        return MessageUtil.success("success",list);
    }

    @ApiOperation("通过id查询用户信息")
    @GetMapping("findAddressById")
    public  Message findAddressById(@ApiParam(value = "主键",required =true)@RequestParam(value ="id") long id){
        List<Address> list= (List<Address>) addressService.findAddressById(id);
        return MessageUtil.success("查询成功",list);

    }

    @GetMapping("deleteAddressById")
    @ApiOperation("通过id删除地址信息")
    public Message deleteAddressById(@ApiParam(value = "主键",required = true)@RequestParam("id")long id) throws  Exception{
        addressService.deleteAddressById(id);
        return MessageUtil.success("删除成功") ;
    }

    @ApiOperation("增加地址")
    @PostMapping("insertAddress")
    public Message insertAddress(@Validated @ModelAttribute Address address) throws Exception {
        addressService.insertAddress(address);
        return MessageUtil.success("增加新的地址成功!");
    }

    @ApiOperation("根据id修改地址")
    @PostMapping("updateAddressPrimaryKey")
    public Message updateAddressPrimaryKey(@Validated@ModelAttribute Address address) throws Exception {
        addressService.updateAddressPrimaryKey(address);
        return MessageUtil.success("修改地址成功！");
    }
    @PostMapping("batchDeleteAddress")
    @ApiOperation("批量删除地址信息")
    public Message batchDelete(@NotNull(message = "ids不能为空") long[] ids) throws Exception{
        addressService.batchDeleteAddress(ids);
        return MessageUtil.success("批量删除成功");
    }
}
