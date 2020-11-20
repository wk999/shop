package wk.sb_do1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wk.sb_do1.dao.TcommodityMapper;
import wk.sb_do1.entity.Tcommodity;
import wk.sb_do1.service.TcommodityService;

import java.util.List;

@Service
public class TcommodityServiceImpl implements TcommodityService {

    @Autowired
    private TcommodityMapper tm;

    @Override
    public List<Tcommodity> query() {
        return tm.query();
    }

    @Override
    public void add(Tcommodity t) {
        tm.add(t);
    }
}
