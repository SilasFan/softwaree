package com.softwaree.softwaree.backend.config;

import com.softwaree.softwaree.backend.security.CustomAccessDeniedHandler;
import com.softwaree.softwaree.backend.security.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] AUTH_WHITELIST = {
            "/backend",
            "/backend/register",
            "/backend/login",
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
    };

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .requestMatchers(CorsUtils::isCorsRequest).permitAll()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .antMatchers("/backend/login", "/backend/register").permitAll()
                .antMatchers("/backend/order/all").hasAuthority("ADMIN")
                .antMatchers("/backend/**").authenticated()
                .and()
                .addFilter(new UsernamePasswordAuthenticationFilter())
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler());

        http.addFilterAt(getJwtFilter(), UsernamePasswordAuthenticationFilter.class);
    }


    @Bean
    public CustomAccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public JwtFilter getJwtFilter() {
        return new JwtFilter();
    }
}
