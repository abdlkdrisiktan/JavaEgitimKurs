package com.bisoft.artistlife.ArtistProject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.*;



@Table(name = "artist")
@Entity
public class Artist {

    //    The ID for the artist.
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

//
//    //    The name of the artist
//    @Getter
//    @Setter
//    private String name;
//
//    //    Hyper link for this artist.
//    @Getter
//    @Setter
//    private String href;
//
//    //    A list of the genres the artist is associated with
//    @Getter
//    @Setter
//    private List<String> genres;
//
//    //    Information about the followers of the artist.
//    @Getter
//    @Setter
//    private List<Followers> followersList;
//
//    //    Images of the artist in various sizes, widest first.
//    @Getter
//    @Setter
//    private List<Images> imagesList;


}
