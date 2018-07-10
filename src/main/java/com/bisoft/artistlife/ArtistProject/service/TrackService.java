package com.bisoft.artistlife.ArtistProject.service;


import com.bisoft.artistlife.ArtistProject.entity.Track;
import com.bisoft.artistlife.ArtistProject.repository.TrackRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackService {


    @Autowired
    TrackRepository trackRepository;
    final Logger logger = LoggerFactory.getLogger("trackLogger");

    public void saveTrackData(Track track){
        trackRepository.save(track);
    }

    public List<Track> getAllTrackData(){
        logger.info(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        return (List<Track>) trackRepository.findAll();
    }
}
