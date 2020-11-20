package wk.sb_do1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wk.sb_do1.dao.CommodityMapper;
import wk.sb_do1.dto.PageBean;
import wk.sb_do1.entity.Commodity;
import wk.sb_do1.service.CommodityService;

import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityMapper cm;

    @Override
    public List<Commodity> queryCommo() {
        return cm.queryCommo();
    }

    @Override
    public List<Commodity> limitCommo(int start, int rows) {
        return cm.limitCommo(start, rows);
    }

    @Override
    public void add(Commodity c) {
        cm.add(c);
    }

    @Override
    public PageBean<Commodity> findByPage(int c, int row) {

        int totalCount = this.queryCommo().size();
        int totalPage = totalCount % row == 0 ? totalCount / row : totalCount / row + 1;

        PageBean<Commodity> pc = new PageBean<>();
        pc.setCurrentPage(c);
        pc.setRow(row);
        pc.setList(this.limitCommo(9 * (c - 1), row));
        pc.setTotalCount(totalCount);
        pc.setTotalPage(totalPage);

        return pc;
    }

    @Override
    public Commodity getCommoById(int id) {
        return cm.getCommoById(id);
    }
}
