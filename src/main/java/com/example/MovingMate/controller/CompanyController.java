package com.example.MovingMate.controller;

import com.example.MovingMate.dto.company.CompanyDto;
import com.example.MovingMate.entity.company.CompanyEntity;
import com.example.MovingMate.service.company.CompanyService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class CompanyController {

//    private final Logger logger =
//            LoggerFactory.getLogger(CompanyController.class);
    private final CompanyService companyService;

    @GetMapping("/company/login")
    public String companyLogin(){
        return "company/login";
    }

    @GetMapping("/company/join")
    public String companyJoin() { return "company/join"; }

    @ResponseBody
    @PostMapping("/member/check")
    public int sendEmail(HttpServletRequest request, String email){
        HttpSession session = request.getSession();
        companyService.mailSend(session, email);
        return 123;

    }



    // 회원가입
    @PostMapping("/company/join")
    public String joinPost(CompanyDto companyDto){

        Long rs = companyService.companyJoin(companyDto);

        return "/index";
    }

    // 회원가입 실패
    @GetMapping("/company/loginFail")
    public String loginFail(){

        return "/company/loginFail";
    }



}
