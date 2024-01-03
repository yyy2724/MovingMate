package com.example.MovingMate.entity.company;

import com.example.MovingMate.constrant.Role;
import com.example.MovingMate.entity.base.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "company")
public class CompanyEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id" )
    private Long id;

    //회사 관련
    @Column(name = "company_name", nullable = true)
    private String companyName;

    @Column(name = "company_email",nullable = false)
    private String email;

    @Column(name = "company_phone",nullable = false)
    private String phone;

    @Column(name = "company_password",nullable = false)
    private String password;

    @Column(name = "company_postcode",nullable = false)
    private String postcode;

    @Column(name = "member_address",nullable = false)
    private String address;

    @Column(name = "member_detailAddress",nullable = false)
    private String detailAddress;

    @Column(name = "member_extraAddress",nullable = false)
    private String extraAddress;

    // 사업자번호
    @Column(name = "business_number", nullable = true)
    private String businessNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;



}
