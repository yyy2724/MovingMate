package com.example.MovingMate.controller.calender;

import com.example.MovingMate.dto.MoveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.*;

@Controller
@RequiredArgsConstructor
public class CalenderController {

    @GetMapping("/calender")
    public String calender(){


        return "/calender";
    }


    @PostMapping("/order/order")
    public String order(MoveDto moveDto, Model model){

        model.addAttribute("moveData",moveDto);

        return "/order/order";
    }
    @GetMapping("/order/order")
    public String order1(MoveDto moveDto, Model model){

        model.addAttribute("moveData",moveDto);


        return "/order/order";
    }


}

