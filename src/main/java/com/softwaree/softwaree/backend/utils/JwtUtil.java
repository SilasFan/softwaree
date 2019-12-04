package com.softwaree.softwaree.backend.utils;

import com.softwaree.softwaree.backend.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;

public class JwtUtil {

    public static String secret = "softwaree";

    public static String generateToken(User user) {
        String role = user.getId() == 1 ? "ADMIN" : "USER";

        SimpleGrantedAuthority authorities = new SimpleGrantedAuthority(role);

        Map<String, Object> claims = new HashMap<>();
        claims.put("USERNAME", user.getUserName());
        claims.put("ROLES", authorities);

        return Jwts.builder().setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 7 * 24 * 60 * 1000))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public static UsernamePasswordAuthenticationToken parseToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();


        Object authorities = claims.get("ROLES");
        LinkedHashMap<String, String> auth = (LinkedHashMap<String, String>) authorities;
        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(auth.get("authority")));

        return new UsernamePasswordAuthenticationToken(claims.get("USERNAME"), null, grantedAuthorities);
    }
}
