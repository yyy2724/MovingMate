package com.example.MovingMate.dto.calender;

import lombok.*;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
    private Long id;

    private String title;

    private LocalDateTime start;

    private LocalDateTime end;

    private boolean allDay;
}
