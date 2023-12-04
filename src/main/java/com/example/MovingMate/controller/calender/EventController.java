package com.example.MovingMate.controller.calender;

import com.example.MovingMate.dto.MoveDto;
import com.example.MovingMate.dto.calender.EventDto;
import com.example.MovingMate.entity.MoveEntity.MoveEntity;
import com.example.MovingMate.entity.calender.EventEntity;
import com.example.MovingMate.repository.MoveRepository;
import com.example.MovingMate.repository.calender.EventRepository;
import com.example.MovingMate.service.MoveService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventController {

    private final EventRepository eventRepository;
    private final MoveRepository moveRepository;
    private final MoveService moveService;

    @PostMapping("/addEvent")
    public ResponseEntity<String> addEvent(@RequestBody MoveDto moveDto){

        MoveEntity moveEntity = MoveEntity.builder()
                .id(moveDto.getId())
                .start(moveDto.getStart())
                .moveWriter(moveDto.getMoveWriter())
                .moveType(moveDto.getMoveType())
                .phone(moveDto.getPhone())
                .firstAddress(moveDto.getFirstAddress())
                .endAddress(moveDto.getEndAddress())
                .build();

        moveRepository.save(moveEntity);  // 이벤트 저장

        return ResponseEntity.ok("일정 추가 완료");
    }




}
