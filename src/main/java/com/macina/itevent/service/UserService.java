package com.macina.itevent.service;

import com.macina.itevent.model.User;
import com.macina.itevent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User AddOneUser(User userToAdd){
        return userRepository.save(userToAdd);
    }
}
