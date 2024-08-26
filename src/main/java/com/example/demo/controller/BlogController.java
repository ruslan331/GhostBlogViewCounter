package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/api/blog")
@CrossOrigin(origins = "*")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/updateViews")
    public ResponseEntity<String> updateViews(@RequestParam String uri, Authentication authentication) {
        try {
            String decodedUri = URLDecoder.decode(uri, StandardCharsets.UTF_8.name());
            blogService.updateViews(decodedUri, authentication);
            return ResponseEntity.ok("Views updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }

    @GetMapping("/getViews")
    public ResponseEntity<Long> getViews(@RequestParam String uri, Authentication authentication) {
        try {
            String decodedUri = URLDecoder.decode(uri, StandardCharsets.UTF_8.name());
            Long views = blogService.getViews(decodedUri, authentication);
            return ResponseEntity.ok(views);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/addView")
    public ResponseEntity<String> addView(@RequestParam String uri, Authentication authentication) {
        try {
            String decodedUri = URLDecoder.decode(uri, StandardCharsets.UTF_8.name());
            blogService.addView(decodedUri, authentication);
            return ResponseEntity.ok("View added successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }

    @GetMapping("/scripts")
    public ResponseEntity<List<?>> getScripts(Authentication authentication) {
        try {
            return ResponseEntity.ok(blogService.getAllScripts(authentication));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
}
