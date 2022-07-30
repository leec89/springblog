package com.example.springblog;

import com.example.springblog.model.Post;
import com.example.springblog.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/posts/create")
    public String displayCreatePost() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String submitCreatePost(@RequestParam String title, @RequestParam String body) {
        Post post = new Post(title, body);
        postDao.save(post);
        return "redirect:/posts";
    }

    // original post create - notice PostMapping!
//    @PostMapping("/posts/create")
//    @ResponseBody
//    public String savePost() {
//        return "Saving post...";
//    }


    //    ~2:17:25 - only testing to show a delete - not how to code a delete

    @PostMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }

    //    ~2:20:25 - show a specific post

    @GetMapping("/posts/{id}")
    public String getPost(Model vModel, @PathVariable Long id) {
        System.out.println(postDao.findById(id).get());
        Post post = postDao.findById(id).get();
        vModel.addAttribute("post", post);
        return "redirect:/posts/show";
    }

}
