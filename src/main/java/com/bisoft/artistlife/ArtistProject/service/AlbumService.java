package com.bisoft.artistlife.ArtistProject.service;

import com.bisoft.artistlife.ArtistProject.entity.Album;
import com.bisoft.artistlife.ArtistProject.entity.Followers;
import com.bisoft.artistlife.ArtistProject.repository.AlbumRepository;
import com.bisoft.artistlife.ArtistProject.repository.FollowerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    FollowerRepository followerRepository;

    final Logger logger = LoggerFactory.getLogger("albumLogger");

    public void saveAlbumData(Album album) {
        logger.info(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        albumRepository.save(album);
    }

    public List<Album> getAllAlbumData() {
        return (List<Album>) albumRepository.findAll();
    }

    public Album getAlbumById(Long id) {
        Album album = albumRepository.findOne(id);
        if (album != null) {
            return album;
        } else {
            album = new Album();
            return album;
        }
    }

    public String deleteAlbumById(Long id) {
        Album album = albumRepository.findOne(id);
        if (album != null) {
            albumRepository.delete(album);
            return "Deleted";
        } else {
            return "Sorry there is no data here :)";
        }
    }

    public String updateAlbumById(Long id, String name) {
        Album album = albumRepository.findOne(id);
        if (album != null) {
            if (!album.getName().contentEquals(name)) {
                album.setName(name);
                albumRepository.save(album);
                return "Updated";
            } else {
                return "Album data name is already updated";
            }
        } else {
            return "Sorry there is no data here :)";
        }
    }

    public void saveAlbumFollowersData(Long followerId, Long albumId) {
        Followers followers = followerRepository.findOne(followerId);
        Album album = albumRepository.findOne(albumId);
        if (followers != null && album != null) {
            List<Followers> tempFollowerList = album.getFollowers();
            boolean isExists = false;
            for (int i = 0; i < tempFollowerList.size(); i++) {
                if (tempFollowerList.get(i).getName().contentEquals(followers.getName())) {
                    isExists = true;
                    System.out.println("is exists" + isExists);
                }
            }
            if (!isExists) {
                tempFollowerList.add(followers);
                album.setFollowers(tempFollowerList);
                albumRepository.save(album);
                System.out.println("album data saved");
            }
        } else {
            if (followers == null)
                System.out.println("followers is null");
            if (album == null)
                System.out.println("album is null");
        }
    }

    public Album findAlbumData(Long albumId) {
        Album album = albumRepository.findOne(albumId);
        if (album != null)
            return album;
        else return new Album();
    }

}
