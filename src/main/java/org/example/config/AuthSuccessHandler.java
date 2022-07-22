package org.example.config;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    JwtTokenUtil tokenUtil;

    @Autowired
    UserRepository userRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        String token = tokenUtil.generateToken(userDetails);
        Cookie cookie = new Cookie("token", token);
        response.addCookie(cookie);
        System.out.println("The user " + username + " has logged in.");
        System.out.println("TOKEN : " + token);
        if(userRepository.getUserByUsername(username).getRoles().equals("NULL"))
        {
            response.sendRedirect("/");
        }
        else if(userRepository.getUserByUsername(username).getRoles().equals("USER")){
            response.sendRedirect("/listAllMenu");
        }
        else if(userRepository.getUserByUsername(username).getRoles().equals("ADMIN")){
            response.sendRedirect("/menuList");
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
