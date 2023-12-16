package com.joe.facebookClone.models;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@Table(name ="Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String postId;
    @Column(nullable = false)
    private String content;

    @Column(columnDefinition = "Integer default 0")
    private Integer likes;

    private String likedBy;


}



