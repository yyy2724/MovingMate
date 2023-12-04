package com.example.MovingMate.entity.admin;

import com.example.MovingMate.entity.base.BaseEntity;
import com.example.MovingMate.constrant.Role;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admin")
public class AdminEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false,name = "admin_id")
    private String adminId;

    @Column(nullable = false, name = "admin_name")
    private String adminName;

    @Column(nullable = false, name = "admin_phone")
    private String adminPhone;

    private String password;

    private Role role;

}
