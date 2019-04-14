package com.paramotor.api.services;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.paramotor.api.data.request.user.UserRequestDTO;
import com.paramotor.api.data.response.json.user.UserResponseDTO;

public interface UserService {

    long userCount();

    UserResponseDTO findById(Long Id);

    UserRequestDTO save(UserRequestDTO user);

    ResponseEntity<?> deleteUser(long id);

    List<UserResponseDTO> findAll();
}
