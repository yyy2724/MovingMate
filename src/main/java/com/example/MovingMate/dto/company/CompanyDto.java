package com.example.MovingMate.dto.company;

import com.example.MovingMate.constrant.Role;
import lombok.*;

import javax.persistence.Column;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {
    private Long id;

    private String companyId;

    private String companyName;

    private String companyPhone;

    private String companyBusinessNumber;

    private String password;

    private Role role;
}
