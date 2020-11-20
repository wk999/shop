package wk.sb_do1.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import wk.sb_do1.entity.User;

@Mapper
@Repository
public interface UserMapper {

    @Select("select * from user where username=#{name}")
    User queryByName(String name);

}
