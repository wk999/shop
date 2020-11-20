package wk.sb_do1.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import wk.sb_do1.entity.Tcommodity;

import java.util.List;

@Mapper
@Repository
public interface TcommodityMapper {

    @Select("select * from tcommodity")
    List<Tcommodity> query();

    @Insert("insert into tcommodity(name,photo,price,tprice) values(#{name},#{photo},#{price},#{tprice})")
    void add(Tcommodity t);
}
