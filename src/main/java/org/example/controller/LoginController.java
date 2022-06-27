package org.example.controller;

import org.example.annotation.AllowAnnonymous;
import org.example.exception.APIResponse;
import org.example.service.LoginService;
import org.example.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
   public JwtUtils jwtUtils;

    @AllowAnnonymous
    @PostMapping("/login")
    public ResponseEntity<APIResponse> login()
    {

        APIResponse apiResponse = loginService.login();

        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }
}
