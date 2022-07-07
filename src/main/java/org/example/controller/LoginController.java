package org.example.controller;
import org.example.config.JwtUtils;
import org.example.dto.LoginRequest;
import org.example.dto.SignupRequest;
import org.example.exception.APIResponse;
import org.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;


@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/signup")
    public ResponseEntity<APIResponse> signUp(@Valid @RequestBody SignupRequest signUpRequest) {
        APIResponse apiResponse = loginService.signUp(signUpRequest);
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<APIResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        APIResponse apiResponse = loginService.login(loginRequest);
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }
}