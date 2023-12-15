package com.example.demo.service;
import com.example.demo.model.Blog;
import com.example.demo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Transactional
    public void updateViews(Integer postId) {
        Blog blog = blogRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Blog post not found"));

        blog.setViews(blog.getViews() + 1);
        blogRepository.save(blog);
        System.out.println("ASDASDASDASDASDA");
    }

    public int getViews(Integer postId) {
        Blog blog = blogRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Blog post not found"));

        return blog.getViews();
    }

    public void addView(Integer postId) {
        Blog blog = new Blog();
        blog.setPostId(postId);
        blog.setViews(0); // Assuming you want to initialize with 1 view

        blogRepository.save(blog);
        System.out.println("View added successfully");
    }

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }
}