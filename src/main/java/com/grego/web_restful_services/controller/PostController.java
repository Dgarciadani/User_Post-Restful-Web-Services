package com.grego.web_restful_services.controller;

import com.grego.web_restful_services.entity.dto.PostDto;
import com.grego.web_restful_services.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public PostDto getPostById(@PathVariable Integer id) {
        return postService.getPostById(id);
    }
    @PostMapping("/")
    public PostDto savePost(@Valid @RequestBody PostDto postDto) {
        return postService.savePost(postDto);
    }
    @DeleteMapping("/{id}")
    public void deletePostById(@PathVariable Integer id) {
        postService.deletePostById(id);
    }
    @PutMapping("/{id}")
    public PostDto updatePost(@PathVariable Integer id, @Valid @RequestBody PostDto postDto) {
        return postService.updatePost(id, postDto);
    }
    @GetMapping("/")
    public List<PostDto> findAll() {
        return postService.findAll();}

    @GetMapping("/user/{id}/posts")
    public List<PostDto> findByUserId(@PathVariable Integer id) {
        return postService.findByUserId(id);
    }
}
