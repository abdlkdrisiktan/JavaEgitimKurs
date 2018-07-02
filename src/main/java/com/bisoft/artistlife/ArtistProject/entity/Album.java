package com.bisoft.artistlife.ArtistProject.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Album {


    //    The ID for the album.
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String name;

    //  The hyper link for the Album
    @Getter
    @Setter
    private String href;

    //    Possible values are “album”, “single”, “derleme”, “appears_on”.
    @Getter
    @Setter
    private String album_group;


    //    The type of the album: one of “album”, “single”, or “compilation”.
    @Getter
    @Setter
    private String album_type;

    @Getter
    @Setter
    private List<Artist> artists;


    //    The cover art for the album in various sizes, widest first.
    @Getter
    @Setter
    private List<Images> imagesList;
}
