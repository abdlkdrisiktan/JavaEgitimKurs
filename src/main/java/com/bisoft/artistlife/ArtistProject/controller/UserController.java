package com.bisoft.artistlife.ArtistProject.controller;


import com.bisoft.artistlife.ArtistProject.entity.User;
import com.bisoft.artistlife.ArtistProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "saveUserData",method = RequestMethod.POST)
    public HttpStatus saveUserData(@RequestBody User user){
        userService.saveUserData(user);
        return HttpStatus.OK;
    }

    @RequestMapping(value = "findUserData",method = RequestMethod.GET)
    public void findUserData(@PathVariable String name){
        userService.findUser(name);
    }
}
