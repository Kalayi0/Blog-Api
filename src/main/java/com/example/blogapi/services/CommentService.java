package com.example.blogapi.services;

import com.example.blogapi.entity.Comment;
import com.example.blogapi.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    // Get all comments
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    // Get comment by ID
    public Optional<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    // Create or update a comment
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    // Delete a comment by ID
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}

