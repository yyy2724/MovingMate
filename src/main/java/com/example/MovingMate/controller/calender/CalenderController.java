package com.example.MovingMate.controller.calender;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CalenderController {

    @GetMapping("/calender")
    public String calender(){


        return "/calender";
    }



}

