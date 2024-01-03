package com.example.MovingMate.dto.company;

import com.example.MovingMate.constrant.Role;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {

    private Long id;
    //회사 관련
    private String companyName;

    private String email;

    private String phone;

    private String password;

    private String postcode;

    private String address;

    private String detailAddress;

    private String extraAddress;

    // 사업자번호
    private String businessNumber;

    private Role role;

    private int price;
}
