package com.grego.web_restful_services.service;

import com.grego.web_restful_services.entity.Post;
import com.grego.web_restful_services.entity.dto.PostDto;
import com.grego.web_restful_services.exeptions.ResourceNotFoundException;
import com.grego.web_restful_services.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService<PostDto> {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PostDto getPostById(Integer id) {
        return postRepository.findById(id).map(this::mapToDTO).orElse(null);
    }

    @Override
    public PostDto savePost(PostDto entity) {
        Post post = mapToEntity(entity);
        post = postRepository.save(post);
        return mapToDTO(post);
    }

    @Override
    public void deletePostById(Integer id) {
        if (postRepository.findById(id).isPresent()) {
            postRepository.deleteById(id);
        }
        throw new ResourceNotFoundException("Post id " + id);

    }

    @Override
    public PostDto updatePost(Integer id, PostDto entity) {
        if (postRepository.findById(id).isPresent()) {
            Post post = mapToEntity(entity);
            post.setId(id);
            post = postRepository.save(post);
            return mapToDTO(post);
        } else {
            throw new ResourceNotFoundException("Post id " + id);
        }
    }


    @Override
    public List<PostDto> findAll() {
        return postRepository.findAll().stream().map(this::mapToDTO).collect(java.util.stream.Collectors.toList());
    }

    //--- Mappers ---
    private PostDto mapToDTO(Post post) {
        return modelMapper.map(post, PostDto.class);
    }

    private Post mapToEntity(PostDto postDto) {
        return modelMapper.map(postDto, Post.class);
    }

}
