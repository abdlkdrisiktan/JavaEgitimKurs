package com.bisoft.artistlife.ArtistProject.controller;


import com.bisoft.artistlife.ArtistProject.entity.Track;
import com.bisoft.artistlife.ArtistProject.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "track")
public class TrackController {



    @Autowired
    TrackService trackService;

    @RequestMapping(value = "saveTrackData",method = RequestMethod.POST)
    public HttpStatus saveTrackData(@RequestBody Track track){
        try {
            trackService.saveTrackData(track);
        }catch (Exception e){
            System.out.println(e);
            return  HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.OK;
    }

    @RequestMapping(value = "getAllTrackData",method = RequestMethod.GET)
    public List<Track> getAllTrackData(){
       return trackService.getAllTrackData();
    }

    @RequestMapping(value = "deleteTrackData", method = RequestMethod.POST)
    public HttpStatus deleteTrackData(@RequestBody Track track){
        trackService.equals(track);
        return HttpStatus.OK;
    }

}
