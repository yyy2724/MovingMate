package com.example.MovingMate.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MoveDto {

    private Long move_id;

    private String name;

    private String moveType;

    private String phone;

    private String firstAddress;

    private String endAddress;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
