package wk.sb_do1.service;

import wk.sb_do1.dto.PageBean;
import wk.sb_do1.entity.Commodity;

import java.util.List;

public interface CommodityService {

    List<Commodity> queryCommo();

    List<Commodity> limitCommo(int start, int rows);

    PageBean<Commodity> findByPage(int c, int row);

    Commodity getCommoById(int id);

    void add(Commodity c);
}
