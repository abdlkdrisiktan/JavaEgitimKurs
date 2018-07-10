package com.bisoft.artistlife.ArtistProject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Table(name = "album")
@Data
@Entity
public class Album {

    //    The ID for the album.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "album_id")
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    //  The hyper link for the Album
    @Column(name = "href")
    private String href;

    //    The type of the album: one of “album”, “single”, or “compilation”.
    @Column(name = "albumType")
    private String albumType;

    @ManyToMany
    private List<Followers> followers;

    @ManyToOne
    private Artist artist;

    @JsonBackReference
    @OneToMany(mappedBy = "album")
    private List<Track> tracks;
}
