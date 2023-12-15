package com.example.demo.model;
import jakarta.persistence.*;

@Entity
@Table(name = "blog_views")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "postid")
    private Integer postid;

    private Integer views;

    // Getters
    public long getId() {
        return id;
    }

    public Integer getPostid() {
        return postid;
    }

    public Integer getViews() {
        return views;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setPostid(Integer postId) {
        this.postid = postId;
    }

    public void setViews(Integer views) {
        this.views = views;
    }
}