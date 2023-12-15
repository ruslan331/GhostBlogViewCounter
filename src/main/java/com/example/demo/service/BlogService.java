package com.example.demo.service;
import com.example.demo.model.Blog;
import com.example.demo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Transactional
    public void updateViews(Integer postId) {
        Optional<Blog> optionalBlog = blogRepository.findByPostId(postId);
        Blog blog = optionalBlog.orElseThrow(() -> new RuntimeException("Blog post not found"));

        blog.setViews(blog.getViews() + 1);
        blogRepository.save(blog);
        System.out.println("ASDASDASDASDASDA");
    }

    public int getViews(Integer postId) {
        Optional<Blog> optionalBlog = blogRepository.findByPostId(postId);
        Blog blog = optionalBlog.orElseThrow(() -> new RuntimeException("Blog post not found"));

        return blog.getViews();
    }

    public void addView(Integer postId) {
        Optional<Blog> optionalBlog = blogRepository.findByPostId(postId);
        Blog blog = optionalBlog.orElseThrow(() -> new RuntimeException("Blog post not found"));
        blog.setPostId(postId);
        blog.setViews(0); // Assuming you want to initialize with 1 view

        blogRepository.save(blog);
        System.out.println("View added successfully");
    }

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }
}