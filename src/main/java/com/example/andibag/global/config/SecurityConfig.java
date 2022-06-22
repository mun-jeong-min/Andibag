package com.example.andibag.global.config;

import com.example.andibag.global.security.jwt.JwtTokenProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;
    private final ObjectMapper objectMapper;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable()
                .formLogin().disable()

                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()

                .antMatchers(HttpMethod.POST, "/notice").authenticated()
                .antMatchers(HttpMethod.GET, "/notice").authenticated()
                .antMatchers(HttpMethod.GET, "/notice/{id}").authenticated()
                .antMatchers(HttpMethod.PUT, "/notice/{id}").authenticated()
                .antMatchers(HttpMethod.DELETE, "/notice/{id}").authenticated()
                
                .antMatchers(HttpMethod.POST, "/user/signup").permitAll()
                .antMatchers(HttpMethod.POST, "/user/login").permitAll()
                .antMatchers(HttpMethod.GET, "/user").authenticated()
                .antMatchers(HttpMethod.GET, "/user/{id}").authenticated()
                
                .antMatchers(HttpMethod.PUT, "/auth").authenticated()

                .antMatchers(HttpMethod.POST, "/comment/{id}").authenticated()
                .antMatchers(HttpMethod.PUT, "/comment/{id}").authenticated()
                .antMatchers(HttpMethod.DELETE, "/comment/{id}").authenticated()
                
                .antMatchers(HttpMethod.POST, "/friend").authenticated()
                .antMatchers(HttpMethod.GET, "/friend").authenticated()

                .antMatchers(HttpMethod.POST, "/reply/{id}").authenticated()

                .anyRequest().permitAll()

                .and()
                .apply(new FilterConfig(jwtTokenProvider, objectMapper));
    }
}
