package com.example.blogapi.services;

import com.example.blogapi.entity.Tag;
import com.example.blogapi.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    // Get all tags
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    // Get tag by ID
    public Optional<Tag> getTagById(Long id) {
        return tagRepository.findById(id);
    }

    // Create or update a tag
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    // Delete a tag by ID
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }
}
