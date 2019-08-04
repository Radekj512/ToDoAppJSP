package pl.sda.filter;

import pl.sda.service.AuthenticationService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//@WebFilter("/to-do/*")
public class AuthenticationFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (AuthenticationService.isAuthenticated(req)){
            super.doFilter(req,res,chain);
        }else{
            res.sendRedirect("/");
        }
    }
}
