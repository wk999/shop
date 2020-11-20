package wk.sb_do1.service;

import wk.sb_do1.entity.Comment;

import java.util.List;

public interface CommentService {

    void add(String comment);

    List<Comment> query();

}
