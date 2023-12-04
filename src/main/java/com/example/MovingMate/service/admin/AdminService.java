package com.example.MovingMate.service.admin;

import com.example.MovingMate.constrant.Role;
import com.example.MovingMate.dto.admin.AdminDto;
import com.example.MovingMate.entity.admin.AdminEntity;
import com.example.MovingMate.repository.admin.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;

    private final PasswordEncoder passwordEncoder;

    public AdminDto adminJoin(AdminDto adminDto) {
        Optional<AdminDto> optionalAdminDto = Optional.ofNullable(adminDto);

        if (optionalAdminDto.isPresent()) {
            AdminEntity adminEntity = AdminEntity.builder()
                    .adminId(adminDto.getAdminId())
                    .adminName(adminDto.getAdminName())
                    .adminPhone(adminDto.getAdminPhone())
                    .password(passwordEncoder.encode(adminDto.getPassword()))
                    .role(Role.ADMIN)
                    .build();


            Long rsId = adminRepository.save(adminEntity).getId();

            Optional<AdminEntity> optionalAdmin =
                    Optional.ofNullable(adminRepository.findById(rsId).orElseThrow(()->{
                        throw new IllegalArgumentException("찾는 아이디가 없습니다.");
                    }));

            return optionalAdmin.map(entity -> AdminDto.builder()
                    .id(entity.getId())
                    .adminId(entity.getAdminId())
                    .adminName(entity.getAdminName())
                    .adminPhone(entity.getAdminPhone())
                    .build()).orElse(null);
        }else {
            return null;
        }
    }
}
