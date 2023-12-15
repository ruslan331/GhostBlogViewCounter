package com.example.demo.controller;
import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import com.example.demo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/updateViews")
    public ResponseEntity<String> updateViews(@RequestParam Integer postId) {
        try {
            blogService.updateViews(postId);
            return ResponseEntity.ok("Views updated successfully");
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception details
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }

    @GetMapping("/getViews")
    public ResponseEntity<Integer> getViews(@RequestParam Integer postId) {
        try {
            int views = blogService.getViews(postId);
            return ResponseEntity.ok(views);
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception details
            return ResponseEntity.status(500).body(-1); // Return a default value or handle as needed
        }
    }
    @GetMapping("/blogViews")
    public String getBlogViews(Model model) {
        System.out.println("Controller method getBlogViews is being called.");
        List<Blog> blogs = blogService.getAllBlogs();
        model.addAttribute("blogs", blogs);
        // Log the data
        blogs.forEach(blog -> System.out.println("Blog ID: " + blog.getId() + ", Post ID: " + blog.getPostId() + ", Views: " + blog.getViews()));
        return "blogViews"; // assuming you have a Thymeleaf template named "blogViews.html"
    }
    @PostMapping("/addView")
    public ResponseEntity<String> addView(@RequestParam Integer postId) {
        try {
            blogService.addView(postId);
            return ResponseEntity.ok("View added successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }
}