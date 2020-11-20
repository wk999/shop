package wk.sb_do1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wk.sb_do1.dao.CommentMapper;
import wk.sb_do1.entity.Comment;
import wk.sb_do1.service.CommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper cm;

    @Override
    public void add(String comment) {
        cm.add(comment);
    }

    @Override
    public List<Comment> query() {
        return cm.query();
    }
}
