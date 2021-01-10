package com.mathBlog.mathBlog.controllers;

import com.mathBlog.mathBlog.models.Post;
import com.mathBlog.mathBlog.models.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BlogController
{
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String blogMain(Model model)
    {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blogMain";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model)
    {
        return "blogAdd";
    }

    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String fullText, Model model)
    {
        Post post = new Post(title, anons, fullText);
        postRepository.save(post);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id,  Model model)
    {
        if(!postRepository.existsById(id))
        {
            return "redirect:/blog";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> arrayListPost = new ArrayList<>();
        post.ifPresent(arrayListPost :: add);
        model.addAttribute("post", arrayListPost);
        return "blogDetails";
    }

    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long id,  Model model)
    {
        if(!postRepository.existsById(id))
        {
            return "redirect:/blog";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> arrayListPost = new ArrayList<>();
        post.ifPresent(arrayListPost :: add);
        model.addAttribute("post", arrayListPost);
        return "blogEdit";
    }
}