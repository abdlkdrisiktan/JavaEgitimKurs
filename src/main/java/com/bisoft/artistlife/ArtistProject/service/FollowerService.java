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

    public void saveFollowersData(Followers followers, Long albumId) {
//        if (followers.getName()!=null)
//            followerRepository.save(followers);
        Album album = albumRepository.findOne(albumId);
        System.out.println(album);
        Followers tempFollower = followerRepository.findByName(followers.getName());
        if (tempFollower.getName().contentEquals(followers.getName())) {
            System.out.println("TEMP FOLLOWER : " + tempFollower);
            List<Album> albumList = tempFollower.getAlbums();
            List<Followers>followersList = new ArrayList<>();
            followersList.add(followers);
            System.out.println(albumList);
            System.out.println("ALBUM : " + album.getFollowers());
            System.out.println("Followers : "+ followers.getAlbums());
            if (albumList == null) {
                albumList = new ArrayList<>();
                if (album != null) {
                    albumList.add(album);
                    tempFollower.setAlbums(albumList);
                    followerRepository.save(tempFollower);
                    System.out.println(tempFollower);
                    album.setFollowers(followersList);
                    albumRepository.save(album);
                    System.out.println("album eklendi 40 line ");
                }
            } else {
                if (album != null) {
                    albumList.add(album);
                    tempFollower.setAlbums(albumList);
                    followerRepository.save(tempFollower);
                    System.out.println(tempFollower);
                    album.setFollowers(followersList);
                    albumRepository.save(album);
                    System.out.println("album eklendi 50 line ");
                }
            }
        } else {
            List<Album> albumList = new ArrayList<>();
            if (album != null) {
                albumList.add(album);
                followers.setAlbums(albumList);
                followerRepository.save(followers);
            } else {
                followerRepository.save(followers);
            }
        }
    }



    public String followAlbumData(Long followerId, Long albumId){
        Followers followers = followerRepository.findOne(followerId);
        Album album = albumRepository.findOne(albumId);
        List<Followers> followersList = album.getFollowers();
        if (followers!=null){
            List<Album> albumList = followers.getAlbums();
            if (albumList!=null){
                albumList.add(album);
                followers.setAlbums(albumList);
                album.setFollowers(followersList);
                followerRepository.save(followers);
                albumRepository.save(album);
            }else {
                albumList = new ArrayList<>();
                albumList.add(album);
                followers.setAlbums(albumList);
                album.setFollowers(followersList);
                followerRepository.save(followers);
                albumRepository.save(album);
            }
            System.out.println("ALBUM : " + album);
            System.out.println("FOLLOWER : " + followers);
            return "You following "+ album.getName()+ " Album.";
        }else {
            return "Followers Null";
        }
    }


}
