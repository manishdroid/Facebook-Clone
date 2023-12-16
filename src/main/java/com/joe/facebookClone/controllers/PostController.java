package com.joe.facebookClone.controllers;

import com.joe.facebookClone.models.Post;
import com.joe.facebookClone.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpSession;


@Controller("/post")

public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/post/home")
    public ModelAndView posts(HttpSession session){
        return new ModelAndView("home").addObject("postDto",new Post());
    }

    public String save(Post post, HttpSession session){
        postService. save(post, session);
        return "redirect:/post/home";
    }

}


