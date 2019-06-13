package com.okami.apps.ej.service.impl;
import com.okami.apps.ej.bean.Comment;
import com.okami.apps.ej.bean.CommentExample;
import com.okami.apps.ej.dao.CommentMapper;
import com.okami.apps.ej.service.ICommentService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
/**
 * 订单评价接口实现
 */
@Service
public class CommentServiceImpl implements ICommentService {
    @Resource
    private CommentMapper commentMapper;


    public List<Comment> findAllComment() {
        return null;
    }

    /***
     * 根据id查询评论
     * @param order_id
     * @return
     */
    @Override
    public List<Comment> findCommentByOrderId(Long order_id) {
        CommentExample commentExample=new CommentExample();
        CommentExample.Criteria criteria=commentExample.createCriteria();
        criteria.andOrderIdEqualTo(order_id);
        return commentMapper.selectByExample(commentExample);
    }

    /***
     * 删除评论
     * @param id
     * @throws Exception
     */
    @Override
    public void deleteCommentById(Long id)throws Exception {
        Comment comment=commentMapper.selectByPrimaryKey(id);
        if(comment == null){
            throw new Exception("要删除的评价不存在");
        } else {
            commentMapper.deleteByPrimaryKey(id);
        }

    }

    /***
     * 增加评论
     * @param comment
     */
    @Override
    public void insertComment(Comment comment) {
//        Long order_id=;//先查询下该订单是否存在，存在
        commentMapper.insertSelective(comment);
    }
}
