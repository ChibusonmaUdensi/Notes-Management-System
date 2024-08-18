package com.example.notesmanagementsystem.service;
import com.example.notesmanagementsystem.data.dto.RequestUserDto;
import com.example.notesmanagementsystem.data.model.User;

import java.util.List;


public interface UserService {
    User createAccount (RequestUserDto requestUserDto);
    String deleteAccount (String userId);
    List <User> findAllUsers ();
    User findUserById(String id);
    User updateUserAccount (RequestUserDto requestUserDto);


}
