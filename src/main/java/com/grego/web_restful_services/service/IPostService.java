package com.grego.web_restful_services.service;

import java.util.List;

public interface IPostService<T> {
    public T getPostById(Integer id);
    public T savePost(T entity);
    public void deletePostById(Integer id);
    public T updatePost(Integer id, T entity);
    public List<T> findAll();

}
