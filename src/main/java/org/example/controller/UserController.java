package org.example.controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.config.JwtTokenUtil;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    Logger logger = LogManager.getLogger(UserController.class);



    @GetMapping("/users")
    public String showUserList(Model model) {
        List<User> user = userRepository.findAll();
        model.addAttribute("user", user);
        return "user-list";
    }
    @GetMapping("/login")
    public String login( Model model) {
        model.addAttribute("user", new User());
        return "/login";
    }

    @PostMapping("/login")
    public String signin(@ModelAttribute User user, Model model, BindingResult result) {
        if (result == null || result.hasErrors()) {
            model.addAttribute("error", "Invalid Email And Password");
            return "/login";
        }
        model.addAttribute("user", userService.Login(user));
        return "redirect:/listAllMenu";
    }

    @GetMapping("/")
    public String signup(User user, Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }


    @PostMapping("/signup")
    public String signUp(@ModelAttribute User user, Model model, BindingResult result, Errors errors) {
        logger.info(user.getFullName());
        logger.info(user.getUsername());
         logger.info(user.getPassword());
//         user.setRoles("USER");
        String encoded = passwordEncoder.encode(user.getPassword());
        logger.info("{}", encoded);
        user.setPassword(passwordEncoder.encode(encoded));
        if (result.hasErrors()) {
            return "signup";
        }
        if (null != errors && errors.getErrorCount() > 0) {
            return "signup";
        } else {
            userRepository.save(user);
            return "redirect:/login";
        }
    }
}


