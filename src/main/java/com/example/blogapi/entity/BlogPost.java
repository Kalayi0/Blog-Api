package com.example.blogapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity  // This annotation makes this class a database entity (table).
public class BlogPost {

    @Id  // Marks this field as the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generate the id value.
    private Long id;

    private String title;

    @Lob  // To handle large content (like text).
    private String comments;

    @Enumerated(EnumType.STRING)  // Restrict status to either "ACTIVE" or "INACTIVE".
    private PostStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;


    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    // Getters and Setters (To allow access and modification)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String content) {
        this.comments = content;
    }

    public PostStatus getStatus() {
        return status;
    }

    public void setStatus(PostStatus status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
