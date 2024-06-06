package com.macina.itevent.service;

import com.macina.itevent.model.User;
import org.springframework.data.domain.Page;

public interface IUserService {

    Page<User> getAllUsers(Integer pageNumber,Integer pageSize);

    User addOneUser(User user);



}
