package com.joe.facebookClone.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@Entity
@Table(name ="Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String authorId;

    @Column(nullable = false)
    private String tittle;

    @Column(nullable = false)
    private String content;

    @Column(columnDefinition = "int default 0")
    private  int likes;

    @Column(nullable = false)
    private  String likedBy;

    @Column(nullable = false)
    private String dateCreated;
}
