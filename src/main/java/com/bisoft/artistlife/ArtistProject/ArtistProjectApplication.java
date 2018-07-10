package com.bisoft.artistlife.ArtistProject;

import com.bisoft.artistlife.ArtistProject.entity.User;
import com.bisoft.artistlife.ArtistProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ArtistProjectApplication implements CommandLineRunner{

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ArtistProjectApplication.class, args);
	}


	@Override
	public void run(String... strings) throws Exception {
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		if (userRepository.count()==0){
			User user = new User();
			user.setName("admin");
			user.setPassword(encoder.encode("admin"));
			userRepository.save(user);
		}
	}
}