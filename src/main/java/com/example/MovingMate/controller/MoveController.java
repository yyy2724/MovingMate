package com.example.MovingMate.controller;

import com.example.MovingMate.entity.*;
import com.example.MovingMate.dto.MoveDto;
import com.example.MovingMate.entity.MoveEntity.MoveEntity;
import com.example.MovingMate.repository.MoveRepository;
import com.example.MovingMate.service.MoveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;


@RequiredArgsConstructor
@Controller
public class MoveController{

    private final MoveService moveService;

    @PostMapping("/move/save")
    public String moveSave(@ModelAttribute MoveDto moveDto, Model model){
        System.out.println(moveDto.getId() + "이게뭐고");

        MoveEntity moveEntity = moveService.moveSave(moveDto);


        System.out.println(moveEntity.getId());
        System.out.println(moveEntity.getPhone());
        System.out.println(moveEntity.getFirstAddress());
        model.addAttribute("moveEntity", moveEntity);

        if (moveEntity != null){
            return "/calender";
        }
        return "index";
    }



}
