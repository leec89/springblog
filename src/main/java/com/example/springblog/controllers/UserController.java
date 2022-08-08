package com.example.springblog.controllers;

import com.example.springblog.model.Post;
import com.example.springblog.model.User;
import com.example.springblog.repositories.PostRepository;
import com.example.springblog.repositories.UserRepository;
import com.example.springblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private PostRepository postDao;
    private UserRepository userDao;
    private PasswordEncoder passwordEncoder;
    private EmailService emailService;

    public UserController(PostRepository postDao, UserRepository userDao, PasswordEncoder passwordEncoder, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    // =================== user URL - single user

    @GetMapping("/user/{id}")
    public String getUser(Model vModel, @PathVariable long id) {
        User user = userDao.findById(id).get();
        vModel.addAttribute("user", user);
        return "users/showuser";
    }

    // =================== user CREATE/REGISTER

    @GetMapping("/signup")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/signup";
    }

    @PostMapping("/signup")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);

        String emailSubject = "A new SpringBlog user account has been created!";
        String emailBlurb = "Thank you for creating your new account in SpringBlog!\r\n\r\nThe username submitted was\r\n[" + user.getUsername() + "].\r\nIf this was not expected, please contact customer support.";
        String emailTo = user.getEmail();

        userDao.save(user);
        emailService.prepareAndSend(emailSubject, emailBlurb, emailTo);

        return "redirect:users/login";
    }

}