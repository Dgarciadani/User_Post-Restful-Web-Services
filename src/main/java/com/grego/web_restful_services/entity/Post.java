package com.grego.web_restful_services.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
@Data
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer id;
    @Size(min = 4, max = 30, message = "Title must be between 4 and 30 characters")
    private String title;
    @Size(min = 10, message = "Description must be at least 10 characters")
    private String content;
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    public Post() {
    }
}
