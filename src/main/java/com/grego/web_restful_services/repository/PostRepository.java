package com.grego.web_restful_services.repository;

import com.grego.web_restful_services.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    public List<Post> findByUserId(Integer id);
}
