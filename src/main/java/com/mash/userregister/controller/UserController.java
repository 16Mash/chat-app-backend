package com.mash.userregister.controller;

import com.mash.userregister.bean.User;
import com.mash.userregister.repository.UserRepository;
import com.mash.userregister.service.UserService;
import com.mash.userregister.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    // Client-side validation makes sure that unfiltered data doesn't even
    // reach the back-end, while server-side validation makes sure
    // that the wrong data isn't processed further.
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
@GetMapping("/")
public String home(){
    return "index";

}
@GetMapping("/register")
public String register(){

    return "signup";
}

    @PostMapping("/create-user")
    public User createUser(@RequestBody User user) {
        User newUser;
        String email = user.getEmail();
        if (userRepository.findByEmail(email).isPresent()) {
         throw new IllegalStateException("user with " + email + " exsists");
        }
        else {
               newUser = userService.createUser(user);
        }
        return newUser;
    }
    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public User login(@RequestBody User user){

        User validUser = null;
        String email = user.getEmail();
        String password =user.getPassword();
        if (email != null && password != null) {
            validUser = userService.findByEmailAndPassword(email,password);
        }
        if(validUser == null){

            throw new IllegalStateException("Bad Credentials!!");
        }
        return validUser;
    }



}
