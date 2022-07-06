//package org.example.controller;
//import org.example.config.JwtUtils;
//import org.example.exception.APIResponse;
//import org.example.service.AuthService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class AuthController {
//    @Autowired
//    private AuthService authService;
//    @Autowired
//   public JwtUtils jwtUtils;
//
//    @PostMapping("/auth")
//    public ResponseEntity<APIResponse> auth()
//    {
//        APIResponse apiResponse = authService.auth();
//        return ResponseEntity
//                .ok()
//                .body(apiResponse);
//    }
//}
