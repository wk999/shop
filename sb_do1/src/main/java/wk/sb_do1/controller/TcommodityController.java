package wk.sb_do1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import wk.sb_do1.entity.Commodity;
import wk.sb_do1.entity.Tcommodity;
import wk.sb_do1.service.CommodityService;
import wk.sb_do1.service.TcommodityService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
public class TcommodityController {

    @Autowired
    private TcommodityService ts;
    @Autowired
    private CommodityService cs;

    @RequestMapping("/t")
    public String t() {
        return "html/tsell_add";
    }

    @RequestMapping("/tadd")
    public String add(@RequestParam("price") int price
            , @RequestParam("name") String name, @RequestParam("tprice") int tprice
            , MultipartFile photo, HttpServletRequest request) throws Exception {

        Tcommodity c = new Tcommodity();
        c.setName(name);
        c.setPrice(price);
        double t = 0.1 * tprice * price;
        c.setTprice(t);

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
        ts.add(c);
        return "html/successful.html";
    }

    @RequestMapping("/query")
    public String query(Model m) {
        List<Tcommodity> ls = ts.query();
        List<Commodity> list = cs.queryCommo();
        m.addAttribute("ls", list);
        m.addAttribute("list", ls);
        return "html/index";
    }


}
