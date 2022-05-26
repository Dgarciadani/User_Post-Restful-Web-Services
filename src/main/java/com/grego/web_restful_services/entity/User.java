package com.grego.web_restful_services.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer id;
    @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
    private String name;
    @Past(message = "Birth date must be in the past")
    private Date birthDate;
    @OneToMany
    @JsonIgnore
    private Iterable<Post> posts;

    public User() {
    }
}

