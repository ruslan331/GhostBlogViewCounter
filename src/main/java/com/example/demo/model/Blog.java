package com.example.demo.model;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "blog_views")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "uri", unique = true, length = 1000)
    private String uri;

    @Column(name = "views")
    private Long views;

    // Getters
    public UUID getId() {
        return id;
    }

    public String getUri() {
        return uri;
    }

    public Long getViews() {
        return views;
    }

    // Setters
    public void setId(UUID id) {
        this.id = id;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setViews(Long views) {
        this.views = views;
    }
}