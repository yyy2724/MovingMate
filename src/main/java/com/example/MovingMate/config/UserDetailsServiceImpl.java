package com.example.MovingMate.config;

import com.example.MovingMate.entity.company.CompanyEntity;
import com.example.MovingMate.repository.company.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    // DB 테이블에 사용자정보 == 입력받은(form)정보를 비교
    private final CompanyRepository companyRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        CompanyEntity companyEntity = companyRepository.findByEmail(email).orElseThrow(()->{
           throw new UsernameNotFoundException("이메일이 존재하지 않습니다.");
        });




        return new MyUserDetails(companyEntity);



    }
}
