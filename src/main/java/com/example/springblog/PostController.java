package com.example.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/posts")                       //viewing all posts
    @ResponseBody                                 //will not need when using Thymeleaf - Justin Spring Views 25:55
    public String getPosts() {
        return "Output of post for exercise 3.1 - Viewing all posts";
    }

    @GetMapping("/posts/{id}")                  //viewing single post
    @ResponseBody
    public String getPost(@PathVariable int id) {
        return "Output of post for exercise 3.2 is id " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String getCreatePostForm() {
        return "Output of post for exercise 3.3 - Getting to form to create post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String savePost() {
        return "Output of post for exercise 3.4 - Saving post from form...";
    }
}
