package com.grego.web_restful_services.service;

import java.util.List;

public interface IUserService<T>  {

    public T getUserById(Integer id);
    public T saveUser(T entity);
    public void deleteUserById(Integer id);
    public T updateUser(Integer id, T entity);
    public List<T> findAll();


}
