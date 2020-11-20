package wk.sb_do1.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import wk.sb_do1.entity.Comment;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {

    @Insert("insert into comment(comment) values(#{comment})")
    void add(String comment);

    @Select("select * from comment")
    List<Comment> query();

}
