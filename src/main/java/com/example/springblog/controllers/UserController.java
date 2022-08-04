package com.example.springblog.controllers;

import com.example.springblog.model.Post;
import com.example.springblog.model.User;
import com.example.springblog.repositories.PostRepository;
import com.example.springblog.repositories.UserRepository;
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

    public UserController(PostRepository postDao, UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
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

    @PostMapping("/users/signup")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/login";
    }

    // =================== user SHOW/VIEW profile

    @GetMapping("/user/profile")
    public String getUserPosts(Model vModel) {
        List<Post> posts = postDao.findAll();
//        User user = userDao.findById(id).get();
//        vModel.addAttribute("user", user);
        vModel.addAttribute("posts", posts);
        return "users/profileview";
    }
}