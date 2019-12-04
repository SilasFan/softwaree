package com.softwaree.softwaree.backend.security;

import com.softwaree.softwaree.backend.utils.JwtUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = httpServletRequest.getHeader("Authorization");
        UsernamePasswordAuthenticationToken authenticationToken;

        if (token != null) {
            try {
                authenticationToken = JwtUtil.parseToken(token);
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            } catch (Exception e) {
                logger.info("token parse failed!");
            }
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
