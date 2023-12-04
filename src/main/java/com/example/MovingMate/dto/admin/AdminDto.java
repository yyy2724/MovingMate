package com.example.MovingMate.dto.admin;

import com.example.MovingMate.constrant.Role;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {

    private Long id;

    private String adminId;

    private String adminName;

    private String adminPhone;

    private String password;

    private Role role;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
