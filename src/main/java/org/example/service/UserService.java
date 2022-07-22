package org.example.service;
import org.example.dto.SignupRequest;
import org.example.exception.APIResponse;
import org.example.model.User;
import org.example.repository.RoleRepository;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
   @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    public UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    public APIResponse SignUp(SignupRequest signupRequest) {
        APIResponse apiResponse = new APIResponse();
        // dto to entity
        User userEntity = new User();
        userEntity.setFullName(signupRequest.getName());
        userEntity.setUsername(signupRequest.getUserName());
        userEntity.setPassword(signupRequest.getPassword());
        // store entity
        userEntity = userRepository.save(userEntity);
        apiResponse.setData(userEntity);
        return apiResponse;
    }


    public APIResponse Login(User user) {
        APIResponse apiResponse = new APIResponse();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
         userRepository.save(user);
        return apiResponse ;
    }

    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

}

