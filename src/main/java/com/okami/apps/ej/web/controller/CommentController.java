package com.okami.apps.ej.web.controller;


import com.okami.apps.ej.bean.Comment;
import com.okami.apps.ej.service.ICommentService;
import com.okami.apps.ej.utils.Message;
import com.okami.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private ICommentService commentService;


    @GetMapping("findAll")
    @ApiOperation("查询所有顾客信息")
    public Message findAll(){
        List<Comment> list=commentService.findAll();
        return MessageUtil.success("success",list);
    }
    @ApiOperation("通过id查询顾客信息")
    @GetMapping("findById")
    public  Message findById(@ApiParam(value = "主键",required =true)@RequestParam(value ="id") long id){
        List<Comment> list= (List<Comment>) commentService.findById(id);
        return MessageUtil.success("查询成功",list);

    }
    @ApiOperation("模糊查询")
    @GetMapping("query")
    public Message query(Comment comment){
        List<Comment> list=commentService.query(comment);
        return MessageUtil.success("success",list);
    }

    @GetMapping("deleteById")
    @ApiOperation("通过id删除顾客信息")
    public String deleteById(@ApiParam(value = "主键",required = true)@RequestParam("id")long id){
        try{
            commentService.deleteById(id);
            return "删除成功";
        }catch(Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
    @ApiOperation("保存或更新顾客信息")
    @GetMapping("saveOrUpdate")
    public Message saveOrUpdate(Comment comment){
        try {
            commentService.saveOrUpdate(comment);
            return MessageUtil.success("保存成功!");
        }catch (Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
    @PostMapping("batchDelete")
    @ApiOperation("批量删除顾客信息")
    public Message batchDelete(@NotNull(message = "ids不能为空") long[] ids) throws Exception{
        commentService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
}
