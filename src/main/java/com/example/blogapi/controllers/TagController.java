package com.example.blogapi.controllers;


import com.example.blogapi.entity.Tag;
import com.example.blogapi.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    // Get all tags
    @GetMapping
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }

    // Get tag by ID
    @GetMapping("/{id}")
    public ResponseEntity<Tag> getTagById(@PathVariable Long id) {
        return tagService.getTagById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new tag
    @PostMapping
    public Tag createTag(@RequestBody Tag tag) {
        return tagService.saveTag(tag);
    }

    // Update an existing tag
    @PutMapping("/{id}")
    public ResponseEntity<Tag> updateTag(@PathVariable Long id, @RequestBody Tag updatedTag) {
        return tagService.getTagById(id)
                .map(existingTag -> {
                    existingTag.setName(updatedTag.getName());
                    return ResponseEntity.ok(tagService.saveTag(existingTag));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a tag
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long id) {
        if (tagService.getTagById(id).isPresent()) {
            tagService.deleteTag(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

