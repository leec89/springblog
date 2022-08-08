package com.example.springblog.controllers;

import com.example.springblog.model.Post;
import com.example.springblog.model.User;
import com.example.springblog.repositories.PostRepository;
import com.example.springblog.repositories.UserRepository;
import com.example.springblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

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

    // =================== random number generator to set pic id index starting point

    Random rand = new Random();
    int RandomPicIndex = rand.nextInt(10000) % 40;


    // =================== posts URL - view ALL posts

    @GetMapping("/posts")
    public String getPosts(Model vModel) {
        List<Post> posts = postDao.findAll();
        vModel.addAttribute("posts", posts);
        vModel.addAttribute("randomPicIndex", RandomPicIndex);
        return "posts/index";
    }

    // =================== post URL - view single post

    @GetMapping("/posts/{id}")
    public String getPost(Model vModel, @PathVariable long id) {
        Post post = postDao.findById(id).get();
        vModel.addAttribute("post", post);
        vModel.addAttribute("randomPicIndex", RandomPicIndex);
        return "posts/showpost";
    }

    // =================== user SHOW/VIEW profile - view user profile

    @GetMapping("/user/profile")
    public String getUserPosts(Model vModel) {
        List<Post> posts = postDao.findAll();
//        User user = userDao.findById(id).get();
//        vModel.addAttribute("user", user);
        vModel.addAttribute("posts", posts);
        vModel.addAttribute("randomPicIndex", RandomPicIndex);
        return "users/profileview";
    }
    // =================== posts CREATE

    @GetMapping("/posts/create")
    public String showCreateForm(Model vModel) {
        vModel.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post newPost) {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        newPost.setUser(principal);
        String emailSubject = "A new SpringBlog post has been created!";
        String emailBlurb = "Thank you for your new post to SpringBlog!\r\n\r\nThe title of your post submitted was\r\n[" + newPost.getTitle() + "].\r\nIf this was not expected, please contact customer support.";
        String emailTo = principal.getEmail();
        postDao.save(newPost);
        emailService.prepareAndSend(emailSubject, emailBlurb, emailTo);
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
            @ModelAttribute Post post
    ) {
        Post postToUpdate = postDao.findById(post.getId()).get();
        postToUpdate.setTitle(post.getTitle());
        postToUpdate.setBody(post.getBody());
        String emailTo = postToUpdate.getUser().getEmail();

        String emailSubject = "A SpringBlog post has been edited!";
        String emailBlurb = "Thank you for your edit to SpringBlog!\r\n\r\nThe title of your post edited was\r\n[" + post.getTitle() + "].\r\nIf this was not expected, please contact customer support.";
        postDao.save(postToUpdate);
        emailService.prepareAndSend(emailSubject, emailBlurb, emailTo);

        return "redirect:/posts";
    }

    // =================== posts DELETE

    @PostMapping("/posts/{id}/delete")
    public String deletePost(
            @PathVariable long id,
            @ModelAttribute Post post
    ) {

        Post postToDelete = postDao.findById(post.getId()).get();
        String emailTo = postToDelete.getUser().getEmail();

        String emailSubject = "A SpringBlog post has been deleted!";
        String emailBlurb = "A SpringBlog has been deleted!\r\n\r\nThe title of the post deleted was\r\n[" + postToDelete.getTitle() + "].\r\n If this was not expected, please contact customer support.";
        postDao.deleteById(id);
        emailService.prepareAndSend(emailSubject, emailBlurb, emailTo);

        return "redirect:/posts";
    }

}
