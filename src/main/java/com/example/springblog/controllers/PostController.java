package com.example.springblog.controllers;

import com.example.springblog.model.Post;
import com.example.springblog.model.User;
import com.example.springblog.repository.PostRepository;
import com.example.springblog.repository.UserRepository;
import com.example.springblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private PostRepository postDao;
    private UserRepository userDao;
    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    // =================== Initial landing on posts URL

    @GetMapping("/")
    public String landing() {
        return "redirect:/posts";
    }

    //    ~2:13:00 - show all the posts
    //    ~2:14:25 - create a post via GET - only testing not how it should be done in real world
    //    ~2:19:45 - update a post is same as create - hibernate knows to update
    //    ~2:17:25 - only testing to show a delete - not how to code a delete
    //    ~2:20:25 - show a specific post

    // =================== posts URL - ALL posts

    @GetMapping("/posts")
    public String getPosts(Model vModel) {
        List<Post> posts = postDao.findAll();
//        List<User> users = userDao.findAll();
        vModel.addAttribute("posts", posts);
        return "posts/index";
    }

    // =================== post URL - single post

    @GetMapping("/posts/{id}")
    public String getPost(Model vModel, @PathVariable long id) {
        Post post = postDao.findById(id).get();
        vModel.addAttribute("post", post);
        return "posts/showpost";
    }

    // =================== posts CREATE

    @GetMapping("/posts/create")
    public String showCreateForm(Model vModel) {
        vModel.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        User user = userDao.findById(1L).get();
        post.setUser(user); // if you don't have a constructor that also takes in the associated user
        postDao.save(post);
        emailService.prepareAndSend(post, "Thanks for creating a post");
        return "redirect:/posts";
    }

    // =================== posts EDIT/UPDATE

    @GetMapping("/posts/{id}/edit")
    public String editPostShow(
            Model vModel,
            @PathVariable long id
    ) {
        Post post = postDao.findById(id).get();
        vModel.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPostSubmit(
            @ModelAttribute Post post,
            @PathVariable long id
    ) {
        postDao.save(post);
        return "redirect:/posts";
    }

    // =================== posts DELETE

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }

    // =================== user URL - single user

    @GetMapping("/user/{id}")
    public String getUser(Model vModel, @PathVariable long id) {
        User user = userDao.findById(id).get();
        vModel.addAttribute("user", user);
        return "users/showuser";
    }

    // =================== user CREATE/REGISTER

    @GetMapping("/user/register")
    public String showUserRegisterForm(Model vModel) {
        vModel.addAttribute("user", new User());
        return "users/register";
    }

    @PostMapping("/user/register")
    public String registerUser(@ModelAttribute User user) {
        userDao.save(user);
        return "redirect:/user/showuser";
    }

    // =================== user SHOW/VIEW profile

    @GetMapping("/user/profile/{id}")
    public String getUserPosts(Model vModel, @PathVariable long id) {
        List<Post> posts = postDao.findAll();
        User user = userDao.findById(id).get();
        vModel.addAttribute("user", user);
        vModel.addAttribute("posts", posts);
        return "users/profileview";
    }

}
