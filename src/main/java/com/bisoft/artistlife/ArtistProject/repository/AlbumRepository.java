package com.bisoft.artistlife.ArtistProject.repository;


import com.bisoft.artistlife.ArtistProject.entity.Album;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlbumRepository extends CrudRepository<Album,Long> {
//        List<Album> findAll();
}
