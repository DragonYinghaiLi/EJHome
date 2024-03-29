package com.okami.apps.ej.web.controller;


import com.okami.apps.ej.bean.Comment;
import com.okami.apps.ej.bean.extend.CommentExtend;
import com.okami.apps.ej.service.ICommentService;
import com.okami.apps.ej.utils.Message;
import com.okami.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
/**
 * 订单评价控制类
 */
@Api(description = "订单评价相关接口")
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private ICommentService commentService;
    @GetMapping("queryBasic")

    @ApiOperation("查询评论信息，返回列表数据")
    public Message queryBasic(Long orderId){
        List<CommentExtend> list = commentService.queryBasic(orderId);
        return MessageUtil.success("success",list);
    }

    @GetMapping("query")
    @ApiOperation("查询评论信息，并且评论级联关键的属性")
    public Message query(Long orderId){
        List<CommentExtend> list = commentService.query(orderId);
        return MessageUtil.success("success",list);
    }
    @ApiOperation("通过订单id查询评论")
    @GetMapping("findCommentByOrderId")
    public Message findCommentByOrderId(
            @ApiParam(value = "order_id",required = true)
            @RequestParam(value = "order_id") Long order_id){
        if(order_id != null){
            List<Comment> findCommentList=commentService.findCommentByOrderId(order_id);
            if(findCommentList.size()==0){

                return MessageUtil.success("根据订单id查询订单评论成功,该订单暂无评论！");
            }else {
                return MessageUtil.success("根据订单id查询订单评论成功！",findCommentList);
            }
        }else{
            return MessageUtil.error("查询失败:订单号获取失败！");
        }
    }

    @ApiOperation("通过评论id删除对应评论")
    @PostMapping("deleteCommentById")
    public Message deleteCommentById(
            @ApiParam(value = "主键",required = true)
            @RequestParam("id") Long id)throws Exception{
        try{
            commentService.deleteCommentById(id);
            return MessageUtil.success("删除成功!");
        } catch(Exception e) {
            e.printStackTrace();
            return MessageUtil.error("删除失败:"+e.getMessage());
        }
    }

    @ApiOperation("新增一条评论")
    @PostMapping("insertComment")
    public Message insertComment(Comment comment){
        commentService.insertComment(comment);
        return  MessageUtil.success("评论成功！");
    }
}