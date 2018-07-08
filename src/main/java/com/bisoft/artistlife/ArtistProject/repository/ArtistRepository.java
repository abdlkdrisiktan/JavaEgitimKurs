package com.bisoft.artistlife.ArtistProject.repository;

import com.bisoft.artistlife.ArtistProject.entity.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist,Long> {

    Artist findByName (String name);
}
