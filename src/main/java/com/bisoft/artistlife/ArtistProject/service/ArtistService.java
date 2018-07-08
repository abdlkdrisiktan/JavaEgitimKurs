package com.bisoft.artistlife.ArtistProject.service;


import com.bisoft.artistlife.ArtistProject.entity.Album;
import com.bisoft.artistlife.ArtistProject.entity.Artist;
import com.bisoft.artistlife.ArtistProject.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {


    @Autowired
    ArtistRepository artistRepository;


    @Autowired
    AlbumService albumService;

    @Autowired
    ArtistService artistService;



    public String saveArtistData(Artist artist){
        Artist tempArtist = artistRepository.findByName(artist.getName());
        if (tempArtist!=null)
            return "Data already exists";
        else{
            artistRepository.save(artist);
            return "Data saved";
        }
    }

    public void saveArtistAlbumData(Long artistId,Long albumId){
        Album album = albumService.findAlbumData(albumId);
        Artist artist = artistService.findArtistData(artistId);
//        List<Album> tempAlbumList = album.get
    }


    public Artist findArtistData(Long artistId){
        Artist artist = artistRepository.findOne(artistId);
        if (artist!=null)
            return artist;
        else
            return new Artist();

    }

}
