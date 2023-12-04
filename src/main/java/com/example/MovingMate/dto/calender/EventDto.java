package com.example.MovingMate.dto.calender;

import com.example.MovingMate.entity.MoveEntity.MoveEntity;
import lombok.*;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;

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

    private List<MoveEntity> moveEntities;
}
