package com.example.MovingMate.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소로 접근하면 권한 및 인증을 미리 체크 하겠다
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfigClass {


    private final AuthenticationFailureHandler customFailureHandler;
//    private final CustomFailureHandler customFailureHandler;

    @Bean
    public static MyUserDetails myUserDetails(){
        return new MyUserDetails();
    }

    @Bean
    public static AuthenticationFailureHandler customFailureHandler() {
        return new CustomFailureHandler();
    }
//    @Bean
//    public CustomFailureHandler customFailureHandler() {
//        return new CustomFailureHandler();
//    }


    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // 홈페이지 보안 공격
        http.csrf().disable();


        http.authorizeHttpRequests()
                // 로그인시 접속 가능
                .antMatchers().authenticated()
                // 모두 접속 가능
                .antMatchers().permitAll()
        ;

        http.formLogin()
                .loginPage("/company/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/index")
                .failureUrl("/company/loginFail")
//                .failureHandler(customFailureHandler())
                .permitAll()
        ;


        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/company/logout")) // 로그아웃 주소
                .deleteCookies("JSESSIONID") // 로그아웃시 JSESSIONID 제거
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutSuccessUrl("/")
        ;

        return http.build();
    }



}
