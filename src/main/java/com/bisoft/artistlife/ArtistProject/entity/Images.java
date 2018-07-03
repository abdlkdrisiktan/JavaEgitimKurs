package com.bisoft.artistlife.ArtistProject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;


public class Images {

    @Getter
    @Setter
    private int height;


    @Getter
    @Setter
    private int width;


    @Getter
    @Setter
    private String url;

}
