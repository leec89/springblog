package com.example.springblog.lectandexer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

//    @GetMapping("/")
//    @ResponseBody
//    public String landing() {
//        return "This is the landing page!";
//    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello from Spring!";
    }

    @GetMapping("/helloworld")
    public String returnHelloWorld(Model vModel) {
        vModel.addAttribute("name", "Chris");
        return "hello-world";
    }

    @GetMapping("/hello1/{inputStr}")
    public String sayHello(Model vModel, @PathVariable String inputStr) {
        vModel.addAttribute("theName", inputStr);
        return "hello";
    }

}
