package com.example.MovingMate.controller;

import com.example.MovingMate.dto.MoveDto;
import com.example.MovingMate.repository.MoveRepository;
import com.example.MovingMate.service.MoveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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


@RequestMapping("/move")
@RequiredArgsConstructor
@Controller
public class MoveController{

    private final MoveService moveService;

    @PostMapping("/save")
    public String moveSave(@ModelAttribute MoveDto moveDto){
        System.out.println(moveDto);
        Long rs = moveService.moveSave(moveDto);

        if (rs != 0){
            return "index";
        }
        return "index";
    }


}
