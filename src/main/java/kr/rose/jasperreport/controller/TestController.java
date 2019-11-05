package kr.rose.jasperreport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/login")
    public String checkLog(){
        return "login/login";
    }

}
