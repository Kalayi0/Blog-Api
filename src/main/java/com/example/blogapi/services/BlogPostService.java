package com.example.blogapi.services;


import com.example.blogapi.entity.BlogPost;
import com.example.blogapi.entity.PostStatus;
import com.example.blogapi.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    // Get all blog posts
    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    // Get a single blog post by ID
    public Optional<BlogPost> getBlogPostById(Long id) {
        return blogPostRepository.findById(id);
    }

    // Create or update a blog post
    public BlogPost saveBlogPost(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    // Delete a blog post by ID
    public void deleteBlogPost(Long id) {
        blogPostRepository.deleteById(id);
    }

    // Get blog posts by status (ACTIVE or INACTIVE)
    public List<BlogPost> getBlogPostsByStatus(PostStatus status) {
        return blogPostRepository.findByStatus(status);
    }
}
