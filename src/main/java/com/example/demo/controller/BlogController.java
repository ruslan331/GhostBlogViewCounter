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
    public ResponseEntity<String> updateViews(@RequestParam String uri) {
        try {
            blogService.updateViews(uri);
            return ResponseEntity.ok("Views updated successfully");
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception details
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }

    @GetMapping("/getViews")
    public ResponseEntity<Long> getViews(@RequestParam String uri) {
        try {
            Long views = blogService.getViews(uri);
            return ResponseEntity.ok(views);
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception details
            return ResponseEntity.status(500).body(-1L); // Return a default value or handle as needed
        }
    }
    @GetMapping("/blogViews")
    public String getBlogViews(Model model) {
        System.out.println("Controller method getBlogViews is being called.");
        List<Blog> blogs = blogService.getAllBlogs();
        model.addAttribute("blogs", blogs);
        // Log the data
        blogs.forEach(blog -> System.out.println("Blog ID: " + blog.getId() + ", Post ID: " + blog.getUri() + ", Views: " + blog.getViews()));
        return "blogViews"; // assuming you have a Thymeleaf template named "blogViews.html"
    }
    @PostMapping("/addView")
    public ResponseEntity<String> addView(@RequestParam String uri) {
        try {
            blogService.addView(uri);
            return ResponseEntity.ok("View added successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }
}