package com.bisoft.artistlife.ArtistProject.controller;

import com.bisoft.artistlife.ArtistProject.entity.Album;
import com.bisoft.artistlife.ArtistProject.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("album")
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @PostMapping(value = "deneme")
    @ResponseBody
    public void deneme(){
        albumService.deneme();
    }

    @PostMapping(value = "saveAlbum")
    public Album saveAlbumData(@RequestParam(value = "name")String name){
        return albumService.saveAlbumData(name);
    }

    @GetMapping(value = "getAllAlbumData")
    public Iterable<Album> getAllAlbumData(){
        return albumService.getAllAlbumData();
    }

}
