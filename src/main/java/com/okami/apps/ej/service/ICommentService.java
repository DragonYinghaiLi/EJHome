package com.okami.apps.ej.service;

import com.okami.apps.ej.bean.Comment;
import com.okami.apps.ej.bean.extend.CommentExtend;

import java.util.List;

/***
 *订单评价接口
 */
public interface ICommentService {
    List<CommentExtend> queryBasic(Long orderId);

    List<CommentExtend> query(Long orderId);
    //查看所有评论
    public List<Comment> findAllComment();
    //根据订单id查询评论
    public List<Comment> findCommentByOrderId(Long order_id);
    //根据评论id删除该订单评论
    public void deleteCommentById(Long id)throws Exception;
    //根据order_id添加对一个订单添加一个评论
    public void insertComment(Comment comment);
}
