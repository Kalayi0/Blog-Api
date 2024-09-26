package com.example.blogapi.repository;

import com.example.blogapi.entity.BlogPost;
import com.example.blogapi.entity.PostStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
    List<BlogPost> findByStatus(PostStatus status);  // Custom method to find blog posts by status.
}
