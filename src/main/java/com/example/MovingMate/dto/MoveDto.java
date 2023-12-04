package com.example.MovingMate.dto;


import com.example.MovingMate.entity.calender.EventEntity;
import lombok.*;

import javax.persistence.Column;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MoveDto {

    private Long id;

    private String moveWriter;

    private String phone;

    private String firstAddress;

    private String endAddress;

    private String moveType;

    private String start;

}
