package com.empleados.app.security;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

public class JWTAuthorizationFilter extends OncePerRequestFilter {
	private final String HEADER = "Authorization";
	private final String PREFIX = "Bearer ";
	private final String SECRET = "hola123";
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		try {
			if(existeJWTToken(request, response)) {
				Claims claims = validateToken(request);
				System.out.println("claims: " + claims.get("authorities"));
				if(claims.get("authorities") != null) {
					setUpSpringAuthentication(claims);
				}else {
					SecurityContextHolder.clearContext();
				}
			}else {
				SecurityContextHolder.clearContext();
			}
			chain.doFilter(request,response);
		}catch(ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
			System.err.println(e.getMessage());
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			System.out.println(e.getMessage());
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN,
					e.getMessage());
		}
		
	}
	private Claims validateToken(HttpServletRequest request) {
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody();
	}
	private void setUpSpringAuthentication(Claims claims) {
		@SuppressWarnings("unchecked")
		List<String> authorities = (List<String>) claims.get("authorities");
		System.out.println("authorities: " + authorities.toString());
		UsernamePasswordAuthenticationToken auth = 
				new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
						authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
		SecurityContextHolder.getContext().setAuthentication(auth);
	}
	private boolean existeJWTToken(HttpServletRequest request, HttpServletResponse response) {
		String authenticationHeader = request.getHeader(HEADER);
		System.err.print(authenticationHeader);
		System.err.print("aqui");
		if(authenticationHeader == null) {
			System.err.println("Null");
		}
		/*if(authenticationHeader != null && authenticationHeader.startsWith(PREFIX)) {
			System.err.print("aqui2");
			return true;
		}*/
		return false;
	}

}
