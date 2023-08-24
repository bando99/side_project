package com.inProject.in.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration                   //spring security 설정
@RequiredArgsConstructor
public class SecurityConfig  {   //WebSecurityConfigurerAdapter 상속받아서 하는 설정 방식은 deprecated됨.
    //대신 개발자가 직접 component-based security 설정을 할 수 있도록 변경되었다. 즉 커스텀 할 설정들을 @Bean으로 등록하여 사용한다.

    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.httpBasic().disable()
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS                  //restapi 기반의 동작 방식 설정. 세션이 아니니 stateless
                )

                .and()

                .authorizeHttpRequests()           //authorizedRequests, antMatchers는 deprecated되서 사용 안 함.
                .requestMatchers(HttpMethod.GET, "/boards/**").permitAll()          //boards로 시작하는 get요청은 다 허용한다는 의미.
                .anyRequest().anonymous()           //기타 요청은 인증을 받지 않아도 모두 접근 가능.
//                .anyRequest().hasRole("ADMIN")       //기타 요청은 admin권한을 가진 사용자가 접근이 가능하다.

                .and()

                .exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler())            //권한을 확인하는 과정에서 예외발생 시 전달할 예외 처리

                .and()
                .exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint())            //인증과정에서 발생하는 예외 처리

                .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return (web) -> web.ignoring().requestMatchers("/");    //인증, 인가를 무시하는 경로. 인증과 인가가 적용되지 않는 리소스를 대상으로 사용.
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
