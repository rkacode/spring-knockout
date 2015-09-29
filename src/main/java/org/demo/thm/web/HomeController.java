package org.demo.thm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping({"", "/"})
    public String index() {
        return "home/index";
    }

    @RequestMapping({"/contact"})
    public String contact() {
        return "home/contact";
    }

    @RequestMapping({"/about"})
    public String about() {
        return "home/about";
    }
}
