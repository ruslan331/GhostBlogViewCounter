package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.model.Script;
import com.example.demo.repository.BlogRepository;
import com.example.demo.repository.ScriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private ScriptRepository scriptRepository;

    @Transactional
    public void updateViews(String uri, Authentication authentication) {
        // Retrieve user ID from Authentication
        String userId = authentication.getName(); // Adjust based on your user details service

        Blog blog = blogRepository.findByUriAndUserId(uri, userId);
        if (blog == null) {
            throw new IllegalArgumentException("Blog not found for the user");
        }
        blog.setViews(blog.getViews() + 1);
        blogRepository.save(blog);
    }

    public Long getViews(String uri, Authentication authentication) {
        String userId = authentication.getName();
        Blog blog = blogRepository.findByUriAndUserId(uri, userId);
        if (blog == null) {
            throw new IllegalArgumentException("Blog not found for the user");
        }
        return blog.getViews();
    }

    public void addView(String uri, Authentication authentication) {
        String userId = authentication.getName();
        Blog blog = blogRepository.findByUriAndUserId(uri, userId);
        if (blog == null) {
            blog = new Blog();
            blog.setUri(uri);
            blog.setViews(0L);
            // Set other required fields, e.g., user ID if applicable
            blogRepository.save(blog);
        }
    }

    public List<Script> getAllScripts(Authentication authentication) {
        String userId = authentication.getName();
        return scriptRepository.findByUserId(userId);
    }
}
