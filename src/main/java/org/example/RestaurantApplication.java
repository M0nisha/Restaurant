package org.example;
import lombok.extern.slf4j.Slf4j;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@Slf4j
@SpringBootApplication
public class RestaurantApplication {
//    @Autowired
//    private UserRepository userRepository;
//
//   @Autowired
//    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(RestaurantApplication.class,args);
    }

//    @PostConstruct
//    void createAdmin() {
//        User user = userRepository.getUserByUsername("addmin@gmail.com");
//        if (user == null) {
//            user = new User("addmin@gmail.com", passwordEncoder.encode("Addmin@1234"));
//            user.setRoles(user.getRoles());
//            userRepository.saveAndFlush(user);
//        } else {
//            log.info("{} {}", user.getUsername(), user.getFullName());
//            log.info("USER EXISTS");
//        }
//    }
}

