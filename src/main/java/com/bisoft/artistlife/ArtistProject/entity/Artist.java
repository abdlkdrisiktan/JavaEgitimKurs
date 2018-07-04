package com.bisoft.artistlife.ArtistProject.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "artist")
public class Artist {


    //    The ID for the album
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "artist")
    private List<Album> albums;


    @OneToMany(mappedBy = "artist")
    private List<Track>tracks;

}
