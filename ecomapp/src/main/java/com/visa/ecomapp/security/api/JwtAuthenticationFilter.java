package com.visa.ecomapp.security.api;

import com.visa.ecomapp.security.service.JwtService;
import com.visa.ecomapp.security.service.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String jwt;
        String userEmail;

        // Make sure this executes only for JWT token
        if(ObjectUtils.isEmpty(authHeader) ||
        !StringUtils.startsWithIgnoreCase(authHeader, "Bearer")) {
            filterChain.doFilter(request, response); // Calls UsernamePasswordAuthenticationFilter
            return;
        }

        jwt = authHeader.substring(7); // leave out Bearer and white space

        userEmail = jwtService.extractEmail(jwt);

    }
}
