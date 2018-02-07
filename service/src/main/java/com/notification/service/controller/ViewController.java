package com.notification.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ViewController {

    @GetMapping("/send-notification")
    public ModelAndView welcome() {
        ModelAndView mav = new ModelAndView("send-notification");
        return mav;
    }
}
