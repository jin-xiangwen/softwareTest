package com.tongji.softwaretest.shikebackend.mapper;

import com.tongji.softwaretest.shikebackend.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {

    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record);

    Comment selectByPrimaryKey(Integer commentId);

    List<Comment> selectAll(Integer storeId);

    int updateByPrimaryKey(Comment record);
}
