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
    @Column(name = "id")
    private Long id;

    @Column(nullable = false,name = "company_id")
    private String companyId;

    @Column(nullable = false, name = "company_name")
    private String companyName;

    @Column(nullable = false, name = "company_phone")
    private String companyPhone;

    @Column(nullable = false, name = "company_business_number")
    private String companyBusinessNumber;

    private String password;

    private Role role;
}
