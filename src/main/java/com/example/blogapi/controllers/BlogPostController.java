package com.example.blogapi.controllers;

import com.example.blogapi.entity.BlogPost;
import com.example.blogapi.entity.PostStatus;
import com.example.blogapi.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    // Get all blog posts
    @GetMapping
    public List<BlogPost> getAllBlogPosts() {
        return blogPostService.getAllBlogPosts();
    }

    // Get a single blog post by ID
    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> getBlogPostById(@PathVariable Long id) {
        return blogPostService.getBlogPostById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new blog post
    @PostMapping
    public BlogPost createBlogPost(@RequestBody BlogPost blogPost) {
        return blogPostService.saveBlogPost(blogPost);
    }

    // Update an existing blog post
    @PutMapping("/{id}")
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable Long id, @RequestBody BlogPost updatedBlogPost) {
        return blogPostService.getBlogPostById(id)
                .map(existingPost -> {
                    existingPost.setTitle(updatedBlogPost.getTitle());
                    existingPost.setContent(updatedBlogPost.getContent());
                    existingPost.setStatus(updatedBlogPost.getStatus());
                    existingPost.setTags(updatedBlogPost.getTags());
                    return ResponseEntity.ok(blogPostService.saveBlogPost(existingPost));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a blog post
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlogPost(@PathVariable Long id) {
        if (blogPostService.getBlogPostById(id).isPresent()) {
            blogPostService.deleteBlogPost(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get blog posts by status (ACTIVE or INACTIVE)
    @GetMapping("/status/{status}")
    public List<BlogPost> getBlogPostsByStatus(@PathVariable String status) {
        return blogPostService.getBlogPostsByStatus(PostStatus.valueOf(status.toUpperCase()));
    }
}

