package com.visa.securitydemo;


import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SampleController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!!!";
    }



    @GetMapping("/user")
    public String sayHelloUser() {
        return "Hello User World!!!";
    }

    @GetMapping("/admin")
    public String sayHelloAdmin() {
        return "Hello Admin!!!";
    }
}
