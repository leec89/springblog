package com.example.springblog;

import com.example.springblog.model.Post;
import com.example.springblog.model.User;
import com.example.springblog.repository.PostRepository;
import com.example.springblog.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private PostRepository postDao;
    private UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    // ~2:13:00 - show all the posts

    @GetMapping("/posts")
    public String getPosts(Model vModel) {
        List<Post> posts = postDao.findAll();
//        List<User> users = userDao.findAll();
        vModel.addAttribute("posts", posts);
        return "posts/index";
    }

    //    ~2:14:25 - create a post via GET - only testing not how it should be done in real world
    //    ~2:19:45 - update a post is same as create - hibernate knows to update

//    @GetMapping("/posts/create")
//    public String displayCreatePost() {
//        return "posts/create";
//    }

//    @PostMapping("/posts/create")
//    public String submitCreatePost(@RequestParam String title, @RequestParam String body) {
//        Post post = new Post(title, body);
//        postDao.save(post);
//        return "redirect:/posts";
//    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model vModel) {
        vModel.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body
    ) {
        User user = userDao.findById(1L).get();
        Post post = new Post(title, body);
        post.setUser(user); // if you don't have a constructor that also takes in the associated user
        postDao.save(post);
        return "redirect:/posts";
    }
    @GetMapping("/posts/edit/{id}")
    public String editPostShow(Model vModel, @PathVariable Long id) {
        Post post = postDao.findById(id).get();
        vModel.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/edit/{id}")
    public String editPostSubmit(
            @ModelAttribute Post post,
            @PathVariable Long id
    ) {

        postDao.save(post);
        return "redirect:/posts";
    }


    //    ~2:17:25 - only testing to show a delete - not how to code a delete

    @PostMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }

    //    ~2:20:25 - show a specific post

    @GetMapping("/posts/{id}")
    public String getPost(Model vModel, @PathVariable Long id) {
        Post post = postDao.findById(id).get();
        vModel.addAttribute("post", post);
        return "posts/show";
    }

}
