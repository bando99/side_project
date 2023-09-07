package com.inProject.in.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration                   //spring security 설정
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig  {   //WebSecurityConfigurerAdapter 상속받아서 하는 설정 방식은 deprecated됨.
    //대신 개발자가 직접 component-based security 설정을 할 수 있도록 변경되었다. 즉 커스텀 할 설정들을 @Bean으로 등록하여 사용한다.

    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.httpBasic().disable()
                .cors()
                .and()

                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS                  //restapi 기반의 동작 방식 설정. 세션이 아니니 stateless
                )

                .and()
                .authorizeHttpRequests()                                                    //authorizedRequests, antMatchers는 deprecated되서 사용 안 함.
                .requestMatchers( "/v3/api-docs/**", "/swagger-ui/**", "/swagger-resources/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/boards/**").permitAll()  //boards로 시작하는 get요청은 다 허용한다는 의미.
                .requestMatchers("/sign/**").permitAll()   //
                .requestMatchers("**exception**").permitAll()
                .requestMatchers("/skillTag**", "/roleNeeded**").permitAll()
//                .anyRequest().hasRole("USER")
//                .anyRequest().anonymous()   //기타 요청은 인증을 받지 않아도 모두 접근 가능.
//                .anyRequest().hasRole("ADMIN")       //기타 요청은 admin권한을 가진 사용자가 접근이 가능하다.
                .anyRequest().authenticated()

                .and()

                .exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler())            //권한을 확인하는 과정에서 예외발생 시 전달할 예외 처리

                .and()
                .exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint())            //인증과정에서 발생하는 예외 처리

                .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class); //후자의 필터로 가기전 Jwt필터를 먼저 거치겠다는 것.


        return httpSecurity.build();
    }

//    @Bean
//    public RoleHierarchy roleHierarchy(){
//        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
//        roleHierarchy.setHierarchy("ROLE_ADMIN > ROLE_USER");     //권한 우선순위 마다 문자열 개행을 해야 한다.
//        return roleHierarchy;
//    }
//
//
//    @Bean
//    public MethodSecurityExpressionHandler methodSecurityExpressionHandler(RoleHierarchy roleHierarchy){  //메서드 수준의 보안을 다루는 인터페이스. 매개변수는 자동으로 주입된다.
//        DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler(); //@PreAuthorize같은 어노테이션으로 메서드 수준 보안을 정의
//        expressionHandler.setRoleHierarchy(roleHierarchy);                                                       //이후 보안 평가식을 평가, 실행한다.
//        return expressionHandler;
//    }
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return (web) -> web.ignoring().requestMatchers("/");    //인증, 인가를 무시하는 경로. 인증과 인가가 적용되지 않는 리소스를 대상으로 사용.
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
