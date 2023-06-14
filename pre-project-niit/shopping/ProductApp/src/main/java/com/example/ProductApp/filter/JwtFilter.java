package com.example.ProductApp.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String authHeader = request.getHeader("Authorization");
        System.out.println("authheader" + authHeader);
        if(authHeader==null || !authHeader.startsWith("Bearer") ){
            throw new ServletException("Token missing");
        }
        else{
            String token = authHeader.substring(7);
            Claims claims= Jwts.parser().setSigningKey("mysecretkey").parseClaimsJws(token).getBody();
            // above parsing throws exception if parsing fails ( token invalid / key invalid )
            System.out.println("claims : " + claims);

            // attach emailid to request
          //  request.setAttribute("user_emailid",claims.getSubject());
            request.setAttribute("email",claims.get("email"));
            request.setAttribute("user_role",claims.get("role"));
            filterChain.doFilter(request,response);
        }
    }
}
