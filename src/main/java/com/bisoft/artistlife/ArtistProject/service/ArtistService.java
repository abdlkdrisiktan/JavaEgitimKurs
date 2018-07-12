package com.bisoft.artistlife.ArtistProject.service;

import com.bisoft.artistlife.ArtistProject.entity.Artist;
import com.bisoft.artistlife.ArtistProject.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {

    @Autowired
    ArtistRepository artistRepository;

    public void saveArtistData(Artist artist){
        artistRepository.save(artist);
    }

    public List<Artist> getAllArtistData (){
        return (List<Artist>) artistRepository.findAll();

    }



}
//
//
//vAs the first answer suggests:
//
//        Do not use Lombok's @Data annotation on @Entity classes.
//
//        Reason: @Data generates hashcode(), equals() and toString() methods that use the generated getters. Using the getter means of course fetching new data even if the property was marked with FetchType=LAZY.
