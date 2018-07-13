package com.bisoft.artistlife.ArtistProject.controller;

import com.bisoft.artistlife.ArtistProject.entity.Album;
import com.bisoft.artistlife.ArtistProject.entity.Followers;
import com.bisoft.artistlife.ArtistProject.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("follower")
public class FollowerController {


    @Autowired
    FollowerService followerService;

    @RequestMapping(value = "saveFollowerData",method = RequestMethod.POST)
    public String saveFollowerData(@RequestBody Followers followers){
          return followerService.saveFollowerData(followers);
    }

//   http://localhost:9090/follower/getFollowedAlbumList/30
    @RequestMapping(value = "getFollowedAlbumList/{followerId}",method = RequestMethod.GET)
    public List<String> getFollowedAlbumList (@PathVariable Long followerId){
        return followerService.getFollowedAlbumList(followerId);
    }


    @RequestMapping(value = "unFollowAlbumData/albumId/{albumId}/followerId/{followerId}",method = RequestMethod.DELETE)
    public void unFollowAlbumData(@PathVariable Long albumId,@PathVariable Long followerId){
        followerService.unFollowAlbumData(albumId,followerId);
    }

    @RequestMapping(value = "getAllFollowerData",method = RequestMethod.GET)
    public List<Followers> getAllFollowerData(){
        return followerService.getAllFollowerData();
    }

    @RequestMapping(value = "followAlbumDataByFollower",method = RequestMethod.POST)
    public void followAlbumDataByFollower(@RequestBody Album album){
        followerService.followAlbumDataByFollower(album);
    }

    @RequestMapping(value = "notFollowedAlbumData",method = RequestMethod.POST)
    public List<Album> notFollowedAlbumData(@RequestBody Followers followers){
        return followerService.notFollowedAlbumData(followers);
    }

}