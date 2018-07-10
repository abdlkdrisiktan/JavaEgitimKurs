package com.bisoft.artistlife.ArtistProject.service;


import com.bisoft.artistlife.ArtistProject.entity.User;
import com.bisoft.artistlife.ArtistProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;


    public void saveUserData(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public User findUser(String name ){
       return userRepository.findByName(name);

    }


}
