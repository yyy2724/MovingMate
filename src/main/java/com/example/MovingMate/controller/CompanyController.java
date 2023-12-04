package com.example.MovingMate.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

//    private final Logger logger =
//            LoggerFactory.getLogger(CompanyController.class);

    @GetMapping("/login")
    public String companyLogin(){
        return "company/login";
    }

}
