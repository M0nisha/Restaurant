package org.example.service;
import org.example.config.JwtUtils;
import org.example.dto.LoginRequest;
import org.example.dto.SignupRequest;
import org.example.exception.APIResponse;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtils jwtUtils;

    public APIResponse signUp(SignupRequest signupRequest) {
        APIResponse apiResponse = new APIResponse();

        // dto to entity
        User userEntity = new User();
        userEntity.setName(signupRequest.getName());
        userEntity.setEmailId(signupRequest.getEmailId());
        userEntity.setPassword(signupRequest.getPassword());

        // store entity
        userEntity = userRepository.save(userEntity);
        apiResponse.setMessage("signedup successfully");
        apiResponse.setData(userEntity);
        return apiResponse;
    }

    public APIResponse login(LoginRequest loginRequest) {

        APIResponse apiResponse = new APIResponse();
        // verify user exist with given email and password
       User user = userRepository.findByEmailIdAndPassword(loginRequest.getEmailId(), loginRequest.getPassword());
        // responses
        if(user == null){
            apiResponse.setData("User login failed");
            return apiResponse;
        }
        // generate jwt
        String token = jwtUtils.generateJwt(user);
        Map<String , Object> data = new HashMap<>();
        data.put("accessToken", token);
        apiResponse.setMessage(" User login successfully");
        apiResponse.setData(data);

        return apiResponse;
    }
}