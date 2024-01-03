package com.example.MovingMate.controller;

import com.example.MovingMate.service.company.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping("/join")
@RestController
@RequiredArgsConstructor
public class MemberCheckController {

    private final CompanyService companyService;

    @PostMapping("/emailCheck")
    public @ResponseBody int emailCheck(@RequestParam("email") String email){

        return companyService.emailCheck(email);
    }

    @PostMapping("/businessNumberCheck")
    public @ResponseBody int businessNumberCheck(@RequestParam("businessNumber") String businessNumber){

        return companyService.businessNumberCheck(businessNumber);
    }

    @PostMapping("/companyCheck")
    public @ResponseBody int companyCheck(@RequestParam("companyName") String companyName){

        return companyService.companyNameCheck(companyName);
    }

    @PostMapping("/phoneCheck")
    public @ResponseBody int phoneCheck(@RequestParam("phone") String phone){

        return companyService.phoneNumberCheck(phone);
    }

    @PostMapping("/emailCheck1")
    public @ResponseBody boolean emailCheck1(HttpServletRequest request, String email, String inputCode){
        HttpSession session =request.getSession();

        boolean result = companyService.emailCertification(session, email, Integer.parseInt(inputCode));


        return result;


    }


}



