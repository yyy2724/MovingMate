package com.example.MovingMate.controller;

import com.example.MovingMate.dto.company.CompanyDto;
import com.example.MovingMate.entity.*;
import com.example.MovingMate.dto.MoveDto;
import com.example.MovingMate.entity.MoveEntity.MoveEntity;
import com.example.MovingMate.repository.MoveRepository;
import com.example.MovingMate.service.MoveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;


@RequiredArgsConstructor
@Controller
public class MoveController {

    private final MoveService moveService;

    // 주문신청
    @PostMapping("/move/save")
    public String moveSave(@ModelAttribute MoveDto moveDto, Model model) {
        System.out.println(moveDto.getId() + "이게뭐고");

        MoveEntity moveEntity = moveService.moveSave(moveDto);


        System.out.println(moveEntity.getId());
        System.out.println(moveEntity.getPhone());
        System.out.println(moveEntity.getFirstAddress());
        model.addAttribute("moveEntity", moveEntity);

        if (moveEntity != null) {
            return "/calender";
        }
        return "index";
    }


    // 모든 주문 목록
    @GetMapping("/move/movingList")
    public String movingList(@PageableDefault(page = 0, size = 5, sort = "id",
            direction = Sort.Direction.DESC)Pageable pageable,
                             @RequestParam(value = "subject", required = false) String subject,
                             @RequestParam(value = "search", required = false) String search,
                             Model model){

        Page<MoveDto> moveEntities = moveService.movePageList(pageable,subject, search);

        Long totalCount = moveEntities.getTotalElements();
        int pagesize = moveEntities.getSize();
        int nowPage = moveEntities.getNumber();
        int totalPage = moveEntities.getTotalPages();
        int blockNum = 3;

        int startPage =
                (int) ((Math.floor(nowPage / blockNum) * blockNum) + 1 <= totalPage ? (Math.floor(nowPage / blockNum) * blockNum) + 1 : totalPage);

        int endPage =
                (startPage + blockNum - 1 < totalPage ? startPage + blockNum - 1 : totalPage);


        for (int i = startPage; i <= endPage; i++) {
            System.out.println(i + " , ");
        }


        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        System.out.println(moveEntities + "moveList 입니다.");
        List<MoveDto> moveList = moveEntities.getContent();
        model.addAttribute("moveList", moveEntities);
        model.addAttribute("move", moveList);

        return "/move/movingList";

    }

    // 금액 설정
    @PostMapping("/move/price")
    public String price1(@ModelAttribute MoveDto moveDto, Model model){

        moveService.updatePrice(moveDto);


        return "redirect:/move/movingList";
    }




}




