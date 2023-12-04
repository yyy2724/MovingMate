package com.example.MovingMate.config.admin;

import com.example.MovingMate.entity.admin.AdminEntity;
import com.example.MovingMate.repository.admin.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminDetailsService implements UserDetailsService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    @Qualifier("adminPasswordEncoder")
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String admin) throws UsernameNotFoundException {
        AdminEntity adminEntity = adminRepository.findByAdminId(admin).orElseThrow(()->{
            throw new UsernameNotFoundException("사용자가 없습니다.");
        });
        return new AdminDetails(adminEntity);
    }
}
