package com.bisoft.artistlife.ArtistProject.service;

import com.bisoft.artistlife.ArtistProject.entity.Album;
import com.bisoft.artistlife.ArtistProject.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    public String deneme(){
        System.out.println("asdasddasa");
        Album album = new Album();
        album.setName("deneme");
        albumRepository.save(album);
        return "asd";
    }

    public Album saveAlbumData(String name){
        Album album = new Album();
        album.setName(name);
        albumRepository.save(album);
        return album;
    }

    public Iterable<Album> getAllAlbumData(){
        return albumRepository.findAll();
    }
}
