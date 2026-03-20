package com.visa.ecomapp.security.service;

import com.visa.ecomapp.security.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String jwtSigningKey;

    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        Collection<String> authorities = userDetails.getAuthorities()
                .stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        User user  = (User) userDetails; // typeCast

        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(user.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 *24))
                .claim("authorities", authorities)
                .claim("iss", "https://server.visa.com:441")
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSigningKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // subject, iat, exp, iss, authorities
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSigningKey)
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public  String extractEmail(String token) {
//        List<String> list = List.of("A", "B", "C");
//        list.forEach(data -> System.out.println(data));
//        list.forEach(System.out::println); // Method REF

        return  extractClaim(token, (claims -> claims.getSubject()));
    }


    private Date extractExpiration(String token) {
        return  extractClaim(token, Claims:: getExpiration);
    }

    private boolean isTokenExpired(String token) {
        // token is created on 20-MAR, expires on 21-MAR
        // USer is using it on 22-MAR - fails new Date() ---> 22-MAR
        return extractExpiration(token).before(new Date());
    }

    // UserDetails from DB
    public  boolean isTokenValid(String token, UserDetails userDetails) {
        final String email = extractEmail(token);
        User user = (User) userDetails;
        return email.equals(user.getEmail()) && !isTokenExpired((token));
    }
}