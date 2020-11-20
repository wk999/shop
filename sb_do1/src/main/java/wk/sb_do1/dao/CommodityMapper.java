package wk.sb_do1.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import wk.sb_do1.entity.Commodity;

import java.util.List;

@Mapper
@Repository
public interface CommodityMapper {

    @Select("select * from commodity")
    List<Commodity> queryCommo();

    @Select("select * from commodity limit #{start},#{rows}")
    List<Commodity> limitCommo(@Param("start") int start, @Param("rows") int rows);

    @Select("select * from commodity where id=#{id}")
    Commodity getCommoById(@Param("id") int id);

    @Insert("insert into commodity(name,photo,price) values(#{name},#{photo},#{price})")
    void add(Commodity c);


}
