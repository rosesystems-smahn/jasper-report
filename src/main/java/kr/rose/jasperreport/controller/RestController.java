package kr.rose.jasperreport.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @RequestMapping(value = "/ht", method = RequestMethod.GET)
    public ModelAndView ht(){

        return null;
    }
}
