package com.example.Blog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Post {

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column
    String title;

    @Column
    String description;
}
