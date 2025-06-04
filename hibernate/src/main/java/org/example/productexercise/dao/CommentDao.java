package org.example.productexercise.dao;

import org.example.productexercise.models.Comment;

public class CommentDao extends BaseDao<Comment>{
    public CommentDao() {
        super(Comment.class);
    }
}
