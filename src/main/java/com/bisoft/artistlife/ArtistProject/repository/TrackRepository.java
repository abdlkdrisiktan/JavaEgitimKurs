package com.bisoft.artistlife.ArtistProject.repository;

import com.bisoft.artistlife.ArtistProject.entity.Track;
import org.springframework.data.repository.CrudRepository;

public interface TrackRepository extends CrudRepository<Track,Long> {

    Track findByName(String name);
}
