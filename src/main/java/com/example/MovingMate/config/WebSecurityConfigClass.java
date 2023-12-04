package com.example.MovingMate.config;

import com.example.MovingMate.config.admin.AdminDetailsService;
import com.example.MovingMate.config.company.CompanyDetailsService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigClass {

    @Configuration
    @Order(0)
    public static class AdminConfig{

        @Bean
        public SecurityFilterChain adminSecurityFilterChain(HttpSecurity http) throws Exception{
            http.authorizeHttpRequests()
                    .antMatchers("/admin/**").permitAll()
//                    .antMatchers().authenticated()
//                    .antMatchers().hasAnyRole()

                    .and()
                    .formLogin()
                    .loginPage("/admin/login")
                    .usernameParameter("adminId")
                    .passwordParameter("password")
                    .loginProcessingUrl("/admin/detail")
                    .failureUrl("/login")
                    .defaultSuccessUrl("/");

            http.logout()
                    .logoutUrl("/admin/logout")
                    .logoutSuccessUrl("/")
                    .and()
                    .csrf().disable()
                    .authenticationProvider(adminAuthenticationProvider());
            return http.build();
        }

        @Bean
        @Primary
        public PasswordEncoder adminPasswordEncoder(){
            return new BCryptPasswordEncoder();
        }

        @Bean
        public AdminDetailsService adminDetailService(){
            return new AdminDetailsService();
        }

        private DaoAuthenticationProvider adminAuthenticationProvider() {
            DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
            provider.setUserDetailsService(adminDetailService());
            provider.setPasswordEncoder(adminPasswordEncoder());
            return provider;
        }
    }

    @Configuration
    @Order(1)
    public static class CompanyConfig{

        @Bean
        public SecurityFilterChain companySecurityFilterChain(HttpSecurity http) throws Exception{
            http.authorizeHttpRequests()
                    .antMatchers("/company/**").permitAll()
//                    .antMatchers().authenticated()
//                    .antMatchers().hasAnyRole()

                    .and()
                    .formLogin()
                    .loginPage("/company/login")
                    .usernameParameter("companyId")
                    .passwordParameter("password")
                    .loginProcessingUrl("/company/detail")
                    .failureUrl("/login")
                    .defaultSuccessUrl("/");

            http.logout()
                    .logoutUrl("/company/logout")
                    .logoutSuccessUrl("/")
                    .and()
                    .csrf().disable()
                    .authenticationProvider(companyAuthenticationProvider());
            return http.build();
        }
        @Bean
        @Qualifier("companyPasswordEncoder")
        public PasswordEncoder companyPasswordEncoder(){
            return new BCryptPasswordEncoder();
        }

        @Bean
        public CompanyDetailsService companyDetailService(){
            return new CompanyDetailsService();
        }

        private DaoAuthenticationProvider companyAuthenticationProvider() {
            DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
            provider.setUserDetailsService(companyDetailService());
            provider.setPasswordEncoder(companyPasswordEncoder());
            return provider;
        }

    }


}
