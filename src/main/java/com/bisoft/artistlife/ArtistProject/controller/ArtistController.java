package com.bisoft.artistlife.ArtistProject.controller;


import com.bisoft.artistlife.ArtistProject.entity.Artist;
import com.bisoft.artistlife.ArtistProject.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("artist")
public class ArtistController {



    @Autowired
    ArtistService artistService;


    @RequestMapping(value = "saveArtistData",method = RequestMethod.POST)
    public String saveArtistData(@RequestBody Artist artist){
        return artistService.saveArtistData(artist);
    }

}
