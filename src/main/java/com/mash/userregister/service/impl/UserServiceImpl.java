package com.mash.userregister.service.impl;

import com.mash.userregister.bean.User;
import com.mash.userregister.repository.UserRepository;
import com.mash.userregister.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User createUser(User user) {
        BCryptPasswordEncoder encrypt = new BCryptPasswordEncoder();
        String ecryptedpassword = encrypt.encode(user.getPassword());
        user.setPassword(ecryptedpassword);
        userRepository.save(user);
        return user;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email,password);
    }

    @Override
    public String authenticateUser(User user){

        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String email = user.getEmail();
        String password =user.getPassword();
        Optional<User> byEmail = userRepository.findByEmail(email);


        if (byEmail.isPresent()) {
            User dbUser = byEmail.get();
            if (bcrypt.matches(password, dbUser.getPassword())) {
                return "Authenticated User";
            }
                else throw new IllegalStateException( "Incorrect Password");
        }

throw new IllegalStateException("We do not have that email in our systems ");

    }

    @Override
    public User addFriend(User user) {







        return null;
    }

}
























