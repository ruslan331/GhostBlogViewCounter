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
    public void updateViews(Integer postid) {
        Blog blog = blogRepository.findByPostid(postid);
        if (blog == null) {
            throw new RuntimeException("Blog post not found");
        }

        blog.setViews(blog.getViews() + 1);
        blogRepository.save(blog);
        System.out.println("ASDASDASDASDASDA");
    }

    public int getViews(Integer postid) {
        Blog blog = blogRepository.findByPostid(postid);
        if (blog == null) {
            throw new RuntimeException("Blog post not found");
        }

        return blog.getViews();
    }

    public void addView(Integer postid) {
        Blog blog = new Blog();
        blog.setPostid(postid);
        blog.setViews(0); // Assuming you want to initialize with 1 view

        blogRepository.save(blog);
        System.out.println("View added successfully");
    }

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }
}