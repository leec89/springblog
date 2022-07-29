package com.example.springblog;

import com.example.springblog.model.Post;
import com.example.springblog.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {

    private PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    // ~2:13:00 - show all the posts

    @GetMapping("/posts")
    public String getPosts(Model vModel) {
        List<Post> posts = postDao.findAll();
        vModel.addAttribute("posts", posts);
        return "posts/index";
    }

    //    ~2:14:25 - create a post via GET - only testing not how it should be done in real world
    //    ~2:19:45 - update a post is same as create - hibernate knows to update

    @GetMapping("/posts/create/test")
    public String createPostTest() {
        Post post = new Post("Blah", "Lorem blah blah blah blah blah");
        postDao.save(post);
        return "redirect:/posts";
    }

    // original post create - notice PostMapping!
    @PostMapping("/posts/create")
    @ResponseBody
    public String savePost() {
        return "Saving post...";
    }


    //    ~2:17:25 - only testing to show a delete - not how to code a delete

    @GetMapping("/posts/delete/test")
    public String deletePostTest() {
        postDao.deleteById(14L);
        return "redirect:/posts";
    }

    //    ~2:20:25 - show a specific post

    @GetMapping("/posts/test/{id}")
    public String getPost(@PathVariable long id) {
        System.out.println(postDao.findById(id).get());
        return "redirect:/posts";
    }

}
