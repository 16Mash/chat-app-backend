package com.mash.userregister.service;

import com.mash.userregister.bean.User;

import java.util.Optional;

public interface UserService {

    public User createUser(User user);
    public User findByEmailAndPassword(String email,String password);

    public String authenticateUser(User user);
    public User addFriend (User user);



}
