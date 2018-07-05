package com.bisoft.artistlife.ArtistProject.service;

import com.bisoft.artistlife.ArtistProject.entity.Album;
import com.bisoft.artistlife.ArtistProject.entity.Followers;
import com.bisoft.artistlife.ArtistProject.repository.AlbumRepository;
import com.bisoft.artistlife.ArtistProject.repository.FollowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    AlbumRepository albumRepository;


    @Autowired
    FollowerRepository followerRepository;

    public Album saveAlbumData(Album album){
        if (album!=null && album.getName()!=null ){
            albumRepository.save(album);
            return album;
        }else {
            return new Album();
        }
    }

    public List<Album> getAllAlbumData(){
        return (List<Album>) albumRepository.findAll();
    }

    public Album getAlbumById(Long id){
        Album album = albumRepository.findOne(id);
        if (album!=null){
            return album;
        }else {
            album= new Album();
            return album;
        }
    }

    public String deleteAlbumById(Long id){
        Album album = albumRepository.findOne(id);
        if (album!=null){
            albumRepository.delete(album);
            return "Deleted";
        } else{
            return "Sorry there is no data here :)";
        }
    }

    public String updateAlbumById(Long id, String name){
        Album album = albumRepository.findOne(id);
        if (album!=null){
            if (!album.getName().contentEquals(name)){
                album.setName(name);
                albumRepository.save(album);
                return "Updated";
            }else {
                return "Album data name is already updated";
            }
        }else {
            return "Sorry there is no data here :)";
        }
    }



}
