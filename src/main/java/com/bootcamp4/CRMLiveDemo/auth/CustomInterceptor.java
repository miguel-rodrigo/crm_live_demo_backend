package com.bootcamp4.CRMLiveDemo.auth;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

public class CustomInterceptor implements HandlerInterceptor {

    private boolean validateCookie(String cookieValue) {
        return cookieValue.equals("all_gucci");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception{

        // Read cookies and find the token
        boolean requestIsAuthorized = false;
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (Cookie cookie : cookies) {
                if ("IDTOKEN".equals(cookie.getName())){
                    requestIsAuthorized = validateCookie(cookie.getValue());
                }
            }
        }

        if (requestIsAuthorized) {
            return true;
        } else {
            response.getWriter().write("not authorized");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }
    }
}
