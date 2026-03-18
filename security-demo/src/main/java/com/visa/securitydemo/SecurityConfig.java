package com.visa.securitydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    DataSource dataSource; // pool of DB connection

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws  Exception {
        builder.jdbcAuthentication().dataSource(dataSource);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//
//    @Bean
//    public InMemoryUserDetailsManager users() {
//        UserDetails user = User.withUsername("harry").password("{noop}secret123").authorities("ROLE_USER").build();
//        UserDetails admin = User.withUsername("rita").password("{noop}secret123").authorities("ROLE_ADMIN", "ROLE_USER").build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        security.authorizeHttpRequests(request -> request.requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/user/**").hasAnyRole("ADMIN", "USER")
                .requestMatchers("/").permitAll())
                .formLogin(Customizer.withDefaults());
        return security.build();
    }
}
