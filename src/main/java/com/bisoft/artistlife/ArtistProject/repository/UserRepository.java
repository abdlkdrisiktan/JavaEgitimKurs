package com.bisoft.artistlife.ArtistProject.repository;


import com.bisoft.artistlife.ArtistProject.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {


    User findByName(String name);
}
