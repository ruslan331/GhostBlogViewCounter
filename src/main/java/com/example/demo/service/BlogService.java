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
        Blog existingBlog = blogRepository.findByPostid(postid);

        if (existingBlog == null) {
            Blog newBlog = new Blog();
            newBlog.setPostid(postid);
            newBlog.setViews(0);

            blogRepository.save(newBlog);
            System.out.println("View added successfully");
        } else {
            System.out.println("View not added, record already exists for postid: " + postid);
        }
    }

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }
}