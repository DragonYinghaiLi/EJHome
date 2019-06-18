package com.okami.apps.ej.dao.extend;

/**
 * @Author: Li
 * @Date: 2019/6/17 22:05
 * @Description:
 */

import com.okami.apps.ej.bean.extend.CommentExtend;
import com.okami.apps.ej.bean.vm.CommentVM;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentExtendMapper {
    List<CommentExtend> query(
            @Param("orderId") Long orderId
    );
    List<CommentVM> queryBasic(
            @Param("orderId") Long orderId
    );
}
