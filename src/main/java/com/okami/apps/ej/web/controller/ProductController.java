package com.okami.apps.ej.web.controller;

import com.okami.apps.ej.bean.Product;
import com.okami.apps.ej.bean.extend.ProductExtend;
import com.okami.apps.ej.service.IProductService;
import com.okami.apps.ej.utils.Message;
import com.okami.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 产品管理控制类
 */
@RestController
@RequestMapping("/product")
@Api(description = "产品管理相关接口")
public class ProductController {
    @Autowired
    private  IProductService productService;
    @GetMapping("queryBasic")
    @ApiOperation("查询产品信息，返回列表数据")
    public Message queryBasic(Long categoryId){
        List<ProductExtend> list = productService.queryBasic(categoryId);
        return MessageUtil.success("success",list);
    }

    @GetMapping("query")
    @ApiOperation("查询产品信息，并且产品级联关键的属性")
    public Message query(Long categoryId){
        List<ProductExtend> list = productService.query(categoryId);
        return MessageUtil.success("success",list);
    }

    @ApiOperation("查询全部上线产品")
    @GetMapping("findAllProduct")
    public Message findAllProduct(){
        List<Product> allProduct=productService.findAllProduct();
        return  MessageUtil.success("查询全部上线产品成功",allProduct);
    }
    @ApiOperation("模糊查询")
    @GetMapping("queryCustomer")
    public Message queryCustomer(Product product){
        List<Product> list=productService.queryCustomer(product);
        return MessageUtil.success("success",list);
    }
    @ApiOperation("分页查询上线产品")
    @GetMapping("findProductByPage")
    public Message findProductByPage(
            @ApiParam(value = "页号",required = true)
            @RequestParam("currentPage")int currentPage){
        //设置页越界检查
        List<Product> pageProduct=productService.findProductByPage(currentPage);
        //判断结果是否为空
        if(pageProduct.get(0)==null) {
            return MessageUtil.error("查询当前页的上线产品失败,没有查询到结果！");
        }else{
            return MessageUtil.success("查询当前页的上线产品成功！", pageProduct);
        }
    }

    @ApiOperation("根据分类id查询上线产品")
    @GetMapping("findProductByCategoryId")
    public Message findProductByCategoryId(
            @ApiParam(value = "分类id",required = true)
            @RequestParam("category_id")Long category_id){
        //查询分类是否存在

        List<Product> categoryProduct=productService.findProductByCategoryId(category_id);
        //判断结果是否为空
        if(categoryProduct.size()==0) {
            return MessageUtil.error("该分类没有查询到结果！");
        }else{
            return MessageUtil.success("查询当前页的上线产品成功！", categoryProduct);
        }
    }
    @ApiOperation("根据产品名称查询")
    @GetMapping("findProductByName")
    public  Message findProductByName(
            @ApiParam(value = "查询产品名",required = true)
            @RequestParam("name") String  name) throws Exception{
        try{
            List<Product> products=productService.findProductByName(name);
            return MessageUtil.success("上线产品数",products);
        }catch (Exception e){
            e.getStackTrace();
            return MessageUtil.error(e.getMessage());

        }
    }
    @ApiOperation("添加产品")
    @PostMapping("insertProduct")
    public Message insertProduct(Product product) throws Exception {
        product.setStatus("1");
        productService.insertProduct(product);
        return MessageUtil.success("添加产品成功！");
    }

    @ApiOperation("批量添加产品")
    @PostMapping("insertBathProduct")
    public Message insertBathProduct(
            @ApiParam(value = "批量添加产品",required = true)
            @RequestBody List<Product> products) {
        try {
            productService.insertBathProduct(products);
            return MessageUtil.success("添加产品成功！");
        }catch (Exception e){
            e.getStackTrace();
            return MessageUtil.error("添加产品失败！"+e.getMessage());
        }
    }

    @ApiOperation("更新产品")
    @PostMapping("updateProduct")
    public Message updateProduct(Product product) throws  Exception{
        productService.updateProduct(product);
        return MessageUtil.success("更新产品成功！");
    }

    @ApiOperation("批量更新产品")
    @PostMapping("UpdateBatchProductStatus")
    public Message UpdateBatchProductStatus(
            @ApiParam(value = "批量更新产品",required = true)
            @RequestParam("status") String status,
            @RequestParam(value = "idList")List<Long> idList){
        Map<String,Object> map = new HashMap<String,Object>();
        if(status.equals("0")||status.equals("1")) {
            try {
                map.put("idList", idList);
                map.put("status", status);
                productService.updateBatchProductStatus(map);
                return MessageUtil.success("更新产品成功！");
            }catch (Exception e){
                e.getStackTrace();
                return MessageUtil.error("更新产品失败！"+e.getMessage());
            }
        }else {
            return  MessageUtil.error("警告传值错误！");
        }
    }

    @ApiOperation("删除产品")
    @PostMapping("deleteProductById")
    public Message deleteProductById(
            @ApiParam(value = "主键",required = true)
            @RequestParam("id") Long id)throws Exception{
        try{
            productService.deleteProductById(id);
            return MessageUtil.success("删除成功!");
        }catch (Exception e){
            e.getStackTrace();
            return MessageUtil.error("删除失败:"+e.getMessage());
        }
    }

    @ApiOperation("批量删除产品")
    @PostMapping("deleteBathProduct")
    public Message deleteBathProduct(
            @ApiParam(value = "主键",required = true)
            @RequestParam(value = "idList") List<Long> idList){
        try{
            productService.deleteBathProduct(idList);
            return MessageUtil.success("删除成功!");
        }catch (Exception e){
            e.getStackTrace();
            return MessageUtil.error("删除失败:"+e.getMessage());
        }
    }

}
