package org.example.service;
import org.example.exception.APIResponse;
import org.example.repository.UserRepository;
import org.example.util.JwtUtils;
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


    public APIResponse login() {

        APIResponse apiResponse = new APIResponse();

        // verify user exist with given email and password
//        User user = userRepository.findOneByEmailIdIgnoreCaseAndPassword(loginRequestDTO.getEmailId(), loginRequestDTO.getPassword());
        // response
//        if(user == null){
//            apiResponse.setData("User login failed");
//            return apiResponse;
//         }
        // generate jwt"


        String token = jwtUtils.generateJwt();
        Map<String , Object> data = new HashMap<>();
        data.put("accessToken", token);
        apiResponse.setData(data);
        return apiResponse;
    }
}
