package com.example.MovingMate.controller;

import com.example.MovingMate.dto.admin.AdminDto;
import com.example.MovingMate.service.admin.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

//    @Autowired
//    private Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @GetMapping("/login")
    public String login(){
        return "admin/login";
    }

    @GetMapping("/join")
    public String join(){
        return "admin/join";
    }

    @PostMapping("/join")
    public String adminJoin(@ModelAttribute AdminDto adminDto, Model model) {
        AdminDto adminDto1 = adminService.adminJoin(adminDto);
        if (adminDto1.getId().equals(0L)) {
            return "admin/join";
        } else {
            model.addAttribute("admins", adminDto1);
            return "admin/detail";
        }
    }


}
