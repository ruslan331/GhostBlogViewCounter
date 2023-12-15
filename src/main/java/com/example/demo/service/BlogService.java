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
    public void updateViews(String uri) {
        Blog blog = blogRepository.findByUri(uri);
        blog.setViews(blog.getViews() + 1);
        blogRepository.save(blog);
        System.out.println("Views updated successfully");
    }

    public Long getViews(String uri) {
        Blog blog = blogRepository.findByUri(uri);
        return blog.getViews();
    }

    public void addView(String uri) {
        Blog blog = new Blog();
        blog.setUri(uri);
        blog.setViews(0L);
        blogRepository.save(blog);
        System.out.println("View added successfully");
    }

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }
}