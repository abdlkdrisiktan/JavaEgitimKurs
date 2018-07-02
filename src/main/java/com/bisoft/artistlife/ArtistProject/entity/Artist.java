package com.bisoft.artistlife.ArtistProject.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.util.List;



public class Artist {

    //    The ID for the artist.
    @Id
    @Getter
    @Setter
    private String id;

    //    The name of the artist
    @Getter
    @Setter
    private String name;

    //    Known external URLs for this artist.
    @Getter
    @Setter
    private String external_url;

    //    A list of the genres the artist is associated with
    @Getter
    @Setter
    private List<String> genres;

    //    Information about the followers of the artist.
    @Getter
    @Setter
    private List<Followers> followersList;

    //    Images of the artist in various sizes, widest first.
    @Getter
    @Setter
    private List<Images> imagesList;


}
