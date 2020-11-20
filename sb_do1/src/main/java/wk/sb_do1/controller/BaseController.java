package wk.sb_do1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wk.sb_do1.entity.Commodity;

@Controller
public class BaseController {

    @RequestMapping("/")
    public String t() {
        return "html/login.html";
    }

    @RequestMapping("/index")
    public String index() {
        return "redirect:/query";
    }


    @RequestMapping("/login")
    public String login() {
        return "html/login.html";
    }

    @RequestMapping("/car")
    public String car() {
        return "html/shopcart.html";
    }

    @RequestMapping("/commodity")
    public String commodity() {
        return "html/sell_add.html";
    }

    @RequestMapping("/buytoday")
    public String buytoday() {
        return "html/buytoday.html";
    }

    @RequestMapping("/information")
    public String information() {
        return "html/information.html";
    }

    @RequestMapping("/about")
    public String about() {
        return "html/about.html";
    }

}
