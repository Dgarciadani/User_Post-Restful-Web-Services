package com.grego.web_restful_services.entity.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {
    private Integer id;
    private String name;
    private Date birthDate;

    public UserDto() {
    }
}
