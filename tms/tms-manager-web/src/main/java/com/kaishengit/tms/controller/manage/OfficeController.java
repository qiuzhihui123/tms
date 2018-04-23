package com.kaishengit.tms.controller.manage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manage/office")
public class OfficeController {


    @GetMapping
    public String home(){

        return "office/home";
    }


}
