package com.spring.prac.controller;

import com.spring.prac.entity.User;
import com.spring.prac.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@RestController
@RequestMapping("/api/users")
@Api(value="userservice", description="Operations pertaining to Users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    UserRepository userRepository;

    @ApiOperation(value = "Register new User")
    @PostMapping("/add")
    public String addNewUser(@RequestParam String firstName,@RequestParam String lastName,@RequestParam String email){

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        userRepository.save(user);
        return "New User Saved";
    }

    @ApiOperation(value = "View a list of available users", response = Iterable.class)
    @GetMapping("/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
/*
        logger.info("inside users all");
        Iterator<User> userIterable = userRepository.findAll().iterator();
        while(userIterable.hasNext()){
            logger.info(userIterable.next().toString());
        }*/
        return userRepository.findAll();
    }


}
