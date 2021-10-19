package com.empleados.app.controllers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empleados.app.entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@CrossOrigin
@RestController
public class UserController {

	@PostMapping("user")
	public User login(@RequestParam("user") String username,
					@RequestParam("password") String pwd) {
		String token = getJWTToken(username);
		//System.err.println("A " + token);
		User user = new User();
		user.setUser(username);
		user.setToken(token);
		System.out.println("Token: "+user.getToken());
		return user;
	}

	private String getJWTToken(String username) {
		String secretKey = "hola123";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
		System.err.println(grantedAuthorities);
		String token = Jwts.builder().setId("softtekJWT").setSubject(username)
				.claim("authorities", grantedAuthorities.stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();
		//System.err.println("B " + token);
		return "Bearer " + token;
	}
	
}
