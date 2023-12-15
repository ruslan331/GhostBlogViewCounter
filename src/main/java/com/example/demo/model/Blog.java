package com.example.demo.model;
import jakarta.persistence.*;

@Entity
@Table(name = "blog_views")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "postId")
    private Integer postId;

    private Integer views;

    // Getters
    public long getId() {
        return id;
    }

    public Integer getPostId() {
        return postId;
    }

    public Integer getViews() {
        return views;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public void setViews(Integer views) {
        this.views = views;
    }
}