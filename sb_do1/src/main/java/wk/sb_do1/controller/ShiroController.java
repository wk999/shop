package wk.sb_do1.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShiroController {

    @RequestMapping("/shiro")
    public String shiro(String username, String pwd, Model m) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, pwd);

        try {
            subject.login(token);
            return "redirect:/query";
        } catch (UnknownAccountException e) {
            m.addAttribute("msg", "用户名错误");
            return "html/login";
        } catch (IncorrectCredentialsException e) {
            m.addAttribute("msg", "密码错误");
            return "html/login";
        }

    }

}
