package com.bisoft.artistlife.ArtistProject.repository;


import com.bisoft.artistlife.ArtistProject.entity.Album;
import org.springframework.data.repository.CrudRepository;



public interface AlbumRepository extends CrudRepository<Album,Long> {
    Album findByName(String name);
}
