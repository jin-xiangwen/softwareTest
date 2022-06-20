package com.tongji.softwaretest.shikebackend.servicelmpl;

import com.tongji.softwaretest.shikebackend.entity.Comment;
import com.tongji.softwaretest.shikebackend.mapper.CommentMapper;
import com.tongji.softwaretest.shikebackend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getCommentList(int storeId) {
        return commentMapper.selectAll(storeId);
    }

    @Override
    public Comment getCommentById(String commentId) {
        return null;
    }

    @Override
    public boolean addComment(Comment comment) {
        int effectedNum = commentMapper.insert(comment);
        if (effectedNum > 0){
            return true;
        } else {
            return false;
        }
    }
}
