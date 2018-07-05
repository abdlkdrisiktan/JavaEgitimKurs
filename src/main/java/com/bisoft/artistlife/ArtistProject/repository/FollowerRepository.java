package com.bisoft.artistlife.ArtistProject.repository;


import com.bisoft.artistlife.ArtistProject.entity.Followers;
import org.springframework.data.repository.CrudRepository;

public interface FollowerRepository extends CrudRepository<Followers,Long> {


    Followers findByName(String name);
}
