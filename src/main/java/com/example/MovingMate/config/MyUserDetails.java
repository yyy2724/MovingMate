package com.example.MovingMate.config;

import com.example.MovingMate.entity.company.CompanyEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Data
@NoArgsConstructor
public class MyUserDetails implements UserDetails {

    private CompanyEntity companyEntity;
    private Map<String, Object> attributes;

    public MyUserDetails(CompanyEntity companyEntity) {
        this.companyEntity = companyEntity;
    }

    // OAuth2.0 로그인 할때 사용할 것 인데 아마 구현 안할듯
    public MyUserDetails(CompanyEntity companyEntity, Map<String, Object> attributes) {
        this.companyEntity = companyEntity;
        this.attributes = attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collectRole = new ArrayList<>();
        collectRole.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ROLE_"+companyEntity.getRole().toString();  // Role_
            }
        });

        return collectRole;
    }

    @Override
    public String getPassword() {
        return companyEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return companyEntity.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
