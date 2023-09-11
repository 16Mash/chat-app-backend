package com.mash.userregister.service.impl;

import com.mash.userregister.bean.User;
import com.mash.userregister.repository.UserRepository;
import com.mash.userregister.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {

        userRepository.save(user);
        return user;
    }


    @Override
    public User findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email,password);
    }

}
