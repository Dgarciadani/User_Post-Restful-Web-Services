package com.grego.web_restful_services.service;

import com.grego.web_restful_services.entity.User;
import com.grego.web_restful_services.entity.dto.UserDto;
import com.grego.web_restful_services.exeptions.ResourceNotFoundException;
import com.grego.web_restful_services.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService<UserDto> {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto getUserById(Integer id) {
        return userRepository.findById(id).map(this::mapToDTO).orElse(null);
    }

    @Override
    public UserDto saveUser(UserDto entity) {
        User user = mapToEntity(entity);
        user = userRepository.save(user);
        return mapToDTO(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        }
        throw new ResourceNotFoundException("User id " + id);


    }

    @Override
    public UserDto updateUser(Integer id, UserDto entity) {
        if (userRepository.findById(id).isPresent()) {
            User user = mapToEntity(entity);
            user.setId(id);
            user = userRepository.save(user);
            return mapToDTO(user);
        } else {
            throw new ResourceNotFoundException("User id " + id);
        }
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(this::mapToDTO).collect(java.util.stream.Collectors.toList());
    }

    //--- Mappers ---
    private UserDto mapToDTO(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    private User mapToEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }


}
