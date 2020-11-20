package wk.sb_do1.service;

import wk.sb_do1.entity.Tcommodity;

import java.util.List;

public interface TcommodityService {

    List<Tcommodity> query();

    void add(Tcommodity t);

}
