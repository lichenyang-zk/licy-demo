package cn.licy.security.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * SecurityController
 *
 * @author lichenyang
 * @since 2022/7/11 17:09
 */
@Controller
public class SecurityController {

    // /**
    //  * 登录
    //  *
    //  * @return 重定向请求
    //  */
    // @RequestMapping("/login")
    // public String login() {
    //     return "redirect:main.html";
    // }

    // 角色权限判断
    // @Secured("ROLE_abc")
    // 注解PreAuthorize的hasRole允许以ROLE_开头，配置类不允许以ROLE_开头，均区分大小写
    @PreAuthorize("hasRole('ROLE_abc')")
    @RequestMapping("/toMain")
    public String main() {
        return "redirect:main.html";
    }

    @RequestMapping("/toError")
    public String error() {
        return "redirect:error.html";
    }

    @GetMapping("/demo")
    // @ResponseBody
    public String demo(){
        return "demo";
    }
}
