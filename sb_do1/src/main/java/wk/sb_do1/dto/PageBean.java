package wk.sb_do1.dto;

import lombok.Data;

import java.util.List;

@Data
public class PageBean<T> {

    //总记录数：
    private int totalCount;
    //总页码
    private int totalPage;
    //每页的数据
    private List<T> list;
    //当前页码
    private int currentPage;
    //每页显示的记录数
    private int row;

}
