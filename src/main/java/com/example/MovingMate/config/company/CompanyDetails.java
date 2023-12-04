package com.example.MovingMate.config.company;

import com.example.MovingMate.entity.company.CompanyEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
public class CompanyDetails implements UserDetails {

    private CompanyEntity companyEntity;

    public CompanyDetails(CompanyEntity company){
        this.companyEntity = company;
    }

    // 권한
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collectRole = new ArrayList<>();
        collectRole.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ROLE_"+companyEntity.getRole().toString();
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
        return companyEntity.getCompanyId();
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
