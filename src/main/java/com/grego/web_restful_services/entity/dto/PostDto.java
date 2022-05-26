package com.grego.web_restful_services.entity.dto;

import com.grego.web_restful_services.entity.User;
import lombok.Data;

@Data
public class PostDto {
    private Integer id;
    private String title;
    private String content;
    private UserDto author;

    public PostDto() {
    }
}
