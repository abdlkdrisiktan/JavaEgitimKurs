package com.bisoft.artistlife.ArtistProject.controller;


import com.bisoft.artistlife.ArtistProject.entity.Artist;
import com.bisoft.artistlife.ArtistProject.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("artist")
public class ArtistController {

    @Autowired
    ArtistService artistService;

    @RequestMapping(value = "saveArtistData",method = RequestMethod.POST)
    public HttpStatus saveArtistData(@RequestBody Artist artist){
         artistService.saveArtistData(artist);
         return HttpStatus.OK;
    }

    @RequestMapping(value = "getAllArtistData",method = RequestMethod.GET)
    public List<Artist> getAllArtistData(){
        return artistService.getAllArtistData();
    }

}
