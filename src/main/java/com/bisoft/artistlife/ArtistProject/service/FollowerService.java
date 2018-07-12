package com.bisoft.artistlife.ArtistProject.service;

import com.bisoft.artistlife.ArtistProject.entity.Album;
import com.bisoft.artistlife.ArtistProject.entity.Followers;
import com.bisoft.artistlife.ArtistProject.repository.AlbumRepository;
import com.bisoft.artistlife.ArtistProject.repository.FollowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("ALL")
@Service
public class FollowerService {


    @Autowired
    FollowerRepository followerRepository;


    @Autowired
    AlbumRepository albumRepository;

    public String saveFollowerData(Followers followers){
        Followers tempFollower = followerRepository.findByName(followers.getName());
        if (tempFollower!=null){
            return "Data already exists";
        }else {
            followerRepository.save(followers);
            return "Data saved";
        }
    }

    public List<String> getFollowedAlbumList(Long followerId){
        List<Album> albumList = (List<Album>) albumRepository.findAll();
        List<String>followedAlbumList= new ArrayList<>();
        for (int i =0;i<albumList.size();i++){
            for (int j=0;j<albumList.get(i).getFollowers().size();j++){
                if (albumList.get(i).getFollowers().get(j).getId().equals(followerId)){
                    followedAlbumList.add(albumList.get(i).getName());
                }
            }
        }
        return followedAlbumList;
    }

    public void unFollowAlbumData (Long albumId,Long followerId){
        //albumId ile albüme git, album içerisinde followerları sırala daha sonra
        //follower ıd göre follower bul ve onu sil.
        Album album = albumRepository.findOne(albumId);
        Followers followers = followerRepository.findOne(followerId);
        if (album!=null && followers!=null){
            for (int i=0;i<album.getFollowers().size();i++){
                if (album.getFollowers().get(i).getId().equals(followerId)){
                    album.getFollowers().remove(i);
                }
            }
            albumRepository.save(album);
            System.out.println(followers.getName() +" unfollow " + album.getName() + " album");
        }else {
            System.out.println("unFollowAlbumData methods There is no album data");
        }
    }

    public String deleteFollower(Long id){
       Followers followers = followerRepository.findOne(id);
        if (followers!=null){
            followerRepository.delete(followers);
            return "Deleted";
        } else{
            return "Sorry there is no data here :)";
        }
    }

    public List<Followers> getAllFollowerData(){
        return (List<Followers>) followerRepository.findAll();
    }

}


