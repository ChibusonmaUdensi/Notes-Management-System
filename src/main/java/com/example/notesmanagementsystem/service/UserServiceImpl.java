package com.example.notesmanagementsystem.service;
import com.example.notesmanagementsystem.data.dto.RequestUserDto;
import com.example.notesmanagementsystem.data.model.User;
import com.example.notesmanagementsystem.data.repository.UserRepository;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User createAccount(RequestUserDto requestUserDto) {
        findByEmail(requestUserDto.getEmail());
        User user = new User();
        user.setUserName(requestUserDto.getUserName());
        user.setEmail(requestUserDto.getEmail());
        user.setPassword(requestUserDto.getPassword());
        userRepository.save(user);
        return user;
    }

    @Override
    public String deleteAccount(String userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            userRepository.delete(optionalUser.get());
            return "User Deleted";
        } else {
            return "User not found, mfjpm";
        }
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(String userId) {
        Optional<User> findUser = userRepository.findById(userId);
        if (findUser.isPresent()) {
            return findUser.get();
        } else {
            throw new NullPointerException("User doesn't exist, fishpieeeeeeee");
        }
    }

    @Override
    public User updateUserAccount(RequestUserDto requestUserDto) {
        Optional<User> userToUpdate = userRepository.findById(requestUserDto.getUserId());
        if (userToUpdate.isPresent()) {
            User updatedUser = userToUpdate.get();
            updatedUser.setPassword(requestUserDto.getPassword());
            updatedUser.setUserName(requestUserDto.getUserName());
            updatedUser.setEmail(requestUserDto.getEmail());
            userRepository.save(updatedUser);
            return updatedUser;
        } else {
            throw new NullPointerException("User not found");
        }
    }

    private void findByEmail(String email){
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()) throw new RuntimeException("Email Address already exists");
    }

}
