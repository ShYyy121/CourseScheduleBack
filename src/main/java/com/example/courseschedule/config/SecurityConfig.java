package com.example.courseschedule.config;

import org.apache.catalina.authenticator.jaspic.AuthConfigFactoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

@Configuration
@EnableJdbcHttpSession
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.GET,"/img/**", "/css/**", "/js/**", "/fonts/**", "/favicon.ico", "/login")
                        .permitAll()
                        .requestMatchers(HttpMethod.OPTIONS, "/**")
                        .permitAll()
                        .requestMatchers(HttpMethod.POST,"/api/teacher/**", "/api/administrator/**", "/api/classroom/**", "/api/major/**", "/api/course/**", "/api/class/**", "/api/grade/**", "/api/schedule/**", "/api/academic-calendar/**")
                        .hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH,"/api/teacher/**", "/api/administrator/**", "/api/classroom/**", "/api/major/**", "/api/course/**", "/api/class/**", "/api/grade/**", "/api/schedule/**", "/api/academic-calendar/**")
                        .hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/api/teacher/**", "/api/administrator/**", "/api/classroom/**", "/api/major/**", "/api/course/**", "/api/class/**", "/api/grade/**", "/api/schedule/**", "/api/academic-calendar/**")
                        .hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/api/teacher/**", "/api/administrator/**", "/api/classroom/**", "/api/major/**", "/api/course/**", "/api/class/**", "/api/grade/**", "/api/schedule/**", "/api/academic-calendar/**")
                        .hasRole("ADMIN")
                        .requestMatchers("/api/**")
                        .hasAnyRole("TEACHER", "ADMIN")
                        .anyRequest()
                        .permitAll()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .permitAll()
                        .defaultSuccessUrl("/redirect",true)
                        .failureHandler((request, response, exception) -> {
                            System.out.println("登录失败:"+exception.getMessage());
                            response.sendRedirect("/login?error");
                        })
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .permitAll()
                );
        return http.build();
    }

    //use to config authentication manager and use userService and passwordEncoder
    @Primary
    @Bean
    public AuthenticationManagerBuilder config(AuthenticationManagerBuilder auth, UserDetailsService userDetailsService) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return rawPassword.toString().equals(encodedPassword);
            }
        });
        return auth;
    }
}
