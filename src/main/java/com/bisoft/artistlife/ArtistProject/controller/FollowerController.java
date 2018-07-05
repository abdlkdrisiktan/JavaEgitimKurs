package com.bisoft.artistlife.ArtistProject.controller;

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

//  http://localhost:9090/follower/saveFollowersData
    @RequestMapping(value = "saveFollowersData/{albumId}",method = RequestMethod.POST)
    public void saveFollowersData(@RequestBody Followers followers, @PathVariable Long albumId){
        followerService.saveFollowersData(followers,albumId);
    }


    @RequestMapping(value = "followAlbumData/followerId/{followerId}/albumId/{albumId}",method = RequestMethod.POST)
    public String followAlbumData(@PathVariable Long followerId,@PathVariable Long albumId){
        return followerService.followAlbumData(followerId,albumId);
    }



}
