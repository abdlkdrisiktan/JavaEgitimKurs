package com.bisoft.artistlife.ArtistProject.util;

import com.bisoft.artistlife.ArtistProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ApplicationSecurityConfig extends GlobalAuthenticationConfigurerAdapter{

    @Autowired
    UserService userService;


    public BCryptPasswordEncoder getPasswordEncode(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

    public void init(AuthenticationManagerBuilder authenticationManagerBuilder)throws Exception{
        authenticationManagerBuilder.userDetailsService(userDetailsService()).passwordEncoder(new BCryptPasswordEncoder());
    }

    UserDetailsService userDetailsService(){
        UserDetailsService detailsService = new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
                return userService.findUser(s);
            }
        };
        if (detailsService!=null)
            return detailsService;
        else
            return null;
    }

}
