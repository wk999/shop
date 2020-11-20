package wk.sb_do1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import wk.sb_do1.dto.PageBean;
import wk.sb_do1.entity.Comment;
import wk.sb_do1.entity.Commodity;
import wk.sb_do1.entity.Tcommodity;
import wk.sb_do1.service.CommentService;
import wk.sb_do1.service.CommodityService;
import wk.sb_do1.service.TcommodityService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
public class CommodityController {

    @Autowired
    private CommodityService cs;
    @Autowired
    private TcommodityService ts;
    @Autowired
    private CommentService ms;

    //    实现分页展示
    @RequestMapping("/commopage")
    public String commopage(@RequestParam("c") int c, Model m) {
        if (c <= 0) {
            c = 1;
        }
        int rows = 9;

        PageBean<Commodity> ps = cs.findByPage(c, rows);
        if (c >= ps.getTotalPage()) {
            PageBean<Commodity> pss = cs.findByPage(ps.getTotalPage(), rows);
            m.addAttribute("ps", pss);
            return "html/commodity";
        } else {
            m.addAttribute("ps", ps);
            return "html/commodity";
        }


    }


    @PostMapping("/add")
    public String add(@RequestParam("name") String name, @RequestParam("price") int price
            , MultipartFile photo, HttpServletRequest request) throws Exception {

        Commodity c = new Commodity();
        c.setName(name);
        c.setPrice(price);

        String path = "E:/Java/Spring Boot/sb_do1/src/main/resources/static/upload/image";
        // 创建File对象，一会向该路径下上传文件
        File file = new File(path);
        // 判断路径是否存在，如果不存在，创建该路径
        if (!file.exists()) {
            file.mkdirs();
        }
        // 获取到上传文件的名称
        String filename = photo.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        // 把文件的名称唯一化
        c.setPhoto(filename);
        // 上传文件
        photo.transferTo(new File(file, filename));
        cs.add(c);
        return "html/successful.html";
    }

    //    展示单个商品
    @RequestMapping("/info")
    public String info(@RequestParam("id") int id, Model m) {
        Commodity sell = cs.getCommoById(id);
        List<Tcommodity> ls = ts.query();
        List<Comment> cs = ms.query();

        m.addAttribute("sell", sell);
        m.addAttribute("list", ls);
        m.addAttribute("ms", cs);
        return "html/details";
    }

    //    实现商品评论的功能；
    @RequestMapping("/comment")
    public String comment(int id, Model m, HttpServletRequest request) {
        String comment = request.getParameter("content");
        ms.add(comment);
        List<Comment> cs = ms.query();
        Commodity sell = this.cs.getCommoById(id);
        List<Tcommodity> ls = ts.query();
        m.addAttribute("sell", sell);
        m.addAttribute("list", ls);
        m.addAttribute("ms", cs);
        return "html/details";
    }

}
