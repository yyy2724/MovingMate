package com.example.MovingMate.dto;
import lombok.*;
import java.time.LocalDateTime;


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
    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
