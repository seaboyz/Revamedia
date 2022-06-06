/**
 * Author(s): @George Henderson
 * Contributor(s):
 * Purpose: CorsFilter
 */
package com.revature.Revamedia.beans.utils;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200"); // Cannot be '*'. If in production we change this to production domain url.
        //response.setHeader("Access-Control-Allow-Origin", "http://220328-revamedia-ui.s3-website-us-east-1.amazonaws.com"); // Cannot be '*'. If in production we change this to production domain url.
        response.setHeader("Access-Control-Allow-Headers", "Origin, Content-Type, Accept, mode"); // Cannot be '*'. Add additional headers we need here.
        filterChain.doFilter(request, response);
    }
}
