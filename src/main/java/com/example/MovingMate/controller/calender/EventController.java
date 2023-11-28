package com.example.MovingMate.controller.calender;

import com.example.MovingMate.dto.calender.EventDto;
import com.example.MovingMate.entity.calender.EventEntity;
import com.example.MovingMate.repository.calender.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EventController {

    private final EventRepository eventRepository;


    @GetMapping("/addEvent")
    public ResponseEntity<String> addEvent(@RequestBody EventDto eventDto){

        EventEntity eventEntity = EventEntity.builder()
                .title(eventDto.getTitle())
                .start(eventDto.getStart())
                .end(eventDto.getEnd())
                .allDay(eventDto.isAllDay())
                .build();

        eventRepository.save(eventEntity);  // 이벤트 저장

        return ResponseEntity.ok("일정 추가 완료");
    }

}
