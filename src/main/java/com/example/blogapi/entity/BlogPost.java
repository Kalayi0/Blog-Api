package com.example.blogapi.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity  // This annotation makes this class a database entity (table).
public class BlogPost {

    @Id  // Marks this field as the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generate the id value.
    private Long id;

    private String title;

    @Lob  // To handle large content (like text).
    private String content;

    @Enumerated(EnumType.STRING)  // Restrict status to either "ACTIVE" or "INACTIVE".
    private PostStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    // One blog post can have many tags.
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "blogpost_tags",
            joinColumns = @JoinColumn(name = "blogpost_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;

    // One blog post can have many comments.
    @OneToMany(mappedBy = "blogPost", cascade = CascadeType.ALL)
    private List<Comment> comments;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
