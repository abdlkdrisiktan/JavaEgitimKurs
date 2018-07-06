package com.bisoft.artistlife.ArtistProject.repository;


import com.bisoft.artistlife.ArtistProject.entity.Album;
import com.bisoft.artistlife.ArtistProject.entity.Followers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AlbumRepository extends CrudRepository<Album,Long> {
    Album findByName(String name);
}
