package com.paramotor.api.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.paramotor.api.data.request.user.UserRequestDTO;
import com.paramotor.api.data.response.json.user.UserResponseDTO;
import com.paramotor.repositories.UserRepository;
import com.paramotor.entity.User;

@Service("userService")
public class UserServiceImpl implements UserService {

    private final
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public long userCount() {
        return userRepository.count();
    }

    public UserResponseDTO findById(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        User user = userRepository.getOne(id);
        return modelMapper.map(user, UserResponseDTO.class);
    }

    public UserRequestDTO save(UserRequestDTO user) {
        ModelMapper modelMapper = new ModelMapper();
        User user_save = modelMapper.map(user, User.class);
        user_save.setDate_created(new Date());
        userRepository.save(user_save);
        return null;
    }

    public ResponseEntity<String> deleteUser(long id) {
        userRepository.deleteById(id);
        return new ResponseEntity<>("User has been deleted!", HttpStatus.OK);
    }

    public List<UserResponseDTO> findAll() {
        List<User> users = new ArrayList<>();

        ModelMapper modelMapper = new ModelMapper();
        userRepository.findAll().forEach(users::add);

        List<UserResponseDTO> usersDTO = new ArrayList<>();

        for (User userTemp : users) {
            usersDTO.add(modelMapper.map(userTemp, UserResponseDTO.class));
        }

        return usersDTO;
    }
}
