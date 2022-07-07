package org.example.config;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

@Slf4j
@Component
public class Interceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (request.getHeader("Authorization") == null) {
            response.setStatus(401);
            response.getWriter().write("UnAuthorized");
            return false;

        }
        String auth = request.getHeader("authorization");
        JwtUtils jwtUtils = new JwtUtils();
        Claims claims = jwtUtils.verify(auth.replace("Bearer ", ""));
        claims.get("name").toString();
        claims.get("emailId").toString();
        return true;
    }
}
