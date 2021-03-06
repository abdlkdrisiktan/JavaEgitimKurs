package com.bisoft.artistlife.ArtistProject.controller;

import com.bisoft.artistlife.ArtistProject.entity.Album;
import com.bisoft.artistlife.ArtistProject.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("album")
public class AlbumController {

    @Autowired
    AlbumService albumService;

//    ******************************************************************
//    Save album methods

//    http://localhost:9090/album/saveAlbumData
    @RequestMapping(value = "saveAlbumData")
    public HttpStatus saveAlbumData(@RequestBody Album album){
         albumService.saveAlbumData(album);
         return HttpStatus.OK;
    }

//    @PostMapping(value = "saveAlbum")
//    public Album saveAlbumData(@RequestParam(value = "name") String name) {
//        return albumService.saveAlbumData(name);
//    }

    @RequestMapping(value = "getAllAlbumData",method = RequestMethod.GET)
    public List<Album> getAllAlbumData() {
        return albumService.getAllAlbumData();
    }

//    ******************************************************************
//    Get album by id methods

//    @GetMapping(value = "getAlbumDataById")
//    public Album getAlbumById(@RequestParam(value = "id")Long id){
//        return albumService.getAlbumById(id);
//    }
    @RequestMapping(value = "getAlbumDataById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Album getAlbumById(@PathVariable Long id) {
        return albumService.getAlbumById(id);

    }

//    ******************************************************************
//    Delete Album methods

//    @DeleteMapping(value = "deleteAlbumDataById")
//    public String deleteAlbumById(@RequestParam Long id){
//        return albumService.deleteAlbumById(id);
//    }
//    http://localhost:9090/album/deleteAlbumDataById/3
//    @RequestMapping(value = "deleteAlbumDataById/{id}", method = RequestMethod.POST)
//    public String deleteAlbumById(@PathVariable Long id) {
//        return albumService.deleteAlbumById(id);
//    }

    @RequestMapping(value = "deleteAlbumData", method = RequestMethod.POST)
    public HttpStatus deleteAlbumData(@RequestBody Album album){
        albumService.deleteAlbumData(album);
        return HttpStatus.OK;
    }

//    ******************************************************************
//    Update Album methods
//    http://localhost:9090/album/updateAlbumDataById?id=1&name=damla

//    @PostMapping(value = "updateAlbumDataById")
//    public String updateAlbumById(@RequestParam Long id, @RequestParam String name) {
//        return albumService.updateAlbumById(id, name);
//    }

//    http://localhost:9090/album/updateAlbumDataById/4/atahan
    @RequestMapping(value = "updateAlbumDataById/{id}/{name}", method = RequestMethod.POST)
    public String updateAlbumDataById(@PathVariable Long id, @PathVariable String name){
        return albumService.updateAlbumById(id,name);
    }

//    http://localhost:9090/follower/saveFollowersData/27/28
    @RequestMapping(value = "saveAlbumFollowersData/{albumId}/{followerId}",method = RequestMethod.POST)
    public void saveAlbumFollowersData(@PathVariable Long followerId, @PathVariable Long albumId){
        albumService.saveAlbumFollowersData(followerId,albumId);
    }






}
