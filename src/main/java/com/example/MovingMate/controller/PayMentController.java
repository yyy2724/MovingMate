package com.example.MovingMate.controller;

import com.example.MovingMate.dto.MoveDto;
import com.example.MovingMate.service.MoveService;
import com.siot.IamportRestClient.IamportClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@RestController
public class PayMentController {

    private final MoveService moveService;

    @PostMapping("/api/pay")
    public ResponseEntity<Integer> payUpdate(@RequestBody MoveDto moveDto){

        int param = moveService.payUpdate(moveDto);
        return new ResponseEntity<>(param, HttpStatus.OK);
    }







}
