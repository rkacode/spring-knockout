package org.demo.thm.web;

import org.demo.thm.model.UserRegistration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @ModelAttribute("genders")
    public List<String> genders() {
        return Arrays.asList("Male", "Female");
    }

    @ModelAttribute("accountTypes")
    public List<String> accountType() {
        return Arrays.asList("Premium", "Standard", "Vip");
    }

    @ModelAttribute("foreignLanguages")
    public List<String> foreignLanguages() {
        return Arrays.asList("English", "German", "French", "Polish");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView userForm() {
        ModelAndView modelAndView = new ModelAndView("user/form");

        modelAndView.addObject("model", new UserRegistration());
        return modelAndView;
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.POST)
    public ModelAndView subtmiUserForm(UserRegistration registration) {
        ModelAndView modelAndView = new ModelAndView("user/form");
        modelAndView.addObject("model", registration);
        return modelAndView;
    }



}
