//package org.example.service;
//import org.example.config.JwtUtils;
//import org.example.exception.APIResponse;
//import org.example.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.HashMap;
//import java.util.Map;
//@Service
//public class AuthService {
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private JwtUtils jwtUtils;
//
//    public APIResponse auth() {
//        APIResponse apiResponse = new APIResponse();
//        String token = jwtUtils.generateJwt(user);
//            Map<String, Object> data = new HashMap<>();
//            data.put("accessToken", token);
//            apiResponse.setData(data);
//          apiResponse.setMessage("success");
//        return apiResponse;
//        }
//}