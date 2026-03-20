package com.visa.ecomapp.security.service;



import com.visa.ecomapp.security.dto.SignInRequest;
import com.visa.ecomapp.security.dto.SignUpRequest;
import com.visa.ecomapp.security.entity.User;
import com.visa.ecomapp.security.repo.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    // register
    public  String signup(SignUpRequest request) {
//        var data = getData();
        var user = User.builder()
        .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(request.getRoles())
                .username(request.getUsername())
                .build();
        System.out.println(user);
        userDao.save(user);
        return "registered !!!";
    }

    // login
    public  String signIn(SignInRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userDao.findByEmail(request.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid email/password"));
        // should generate Token and send it back
        return jwtService.generateToken(user);
    }

}

