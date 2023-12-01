package com.example.MovingMate.config.company;

import com.example.MovingMate.entity.company.CompanyEntity;
import com.example.MovingMate.repository.company.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CompanyDetailsService implements UserDetailsService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public UserDetails loadUserByUsername(String companyId) throws UsernameNotFoundException {
        CompanyEntity companyEntity = companyRepository.findByCompanyId(companyId).orElseThrow(()-> new UsernameNotFoundException("회사정보가 없습니다."));
        return new CompanyDetails(companyEntity);
    }
}
