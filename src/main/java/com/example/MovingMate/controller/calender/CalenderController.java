package com.example.MovingMate.controller.calender;

import com.example.MovingMate.dto.MoveDto;
import com.example.MovingMate.entity.MoveEntity.MoveEntity;
import com.example.MovingMate.service.MoveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class CalenderController {

    private final MoveService moveService;

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



    // 주문 내역 찾기
    @GetMapping("/order/orderSearchNum")
    public String search1(){

        return "/order/orderSearchNum";
    }
    @PostMapping("/order/orderSearchNum")
    public String search2(Long id, Model model){

        Optional<MoveEntity> optionalMoveEntity = moveService.searchOrder(id);

        if(optionalMoveEntity.isPresent()){
            MoveEntity moveEntity = optionalMoveEntity.get();


            String startTimeString = moveEntity.getStart(); // Z 제거
            ZonedDateTime startTime = ZonedDateTime.parse(startTimeString);

            DateTimeFormatter outputFormatter  = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분");
            String formattedDate = startTime.format(outputFormatter);

            model.addAttribute("formattedDate", formattedDate);
            model.addAttribute("moveEntity", moveEntity);
            return "/order/search";
        } else{
            return "error";
        }



    }



}

