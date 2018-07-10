package com.bisoft.artistlife.ArtistProject.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    //  Artist name
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "artist")
    private List<Album> albums;

//    @OneToMany(mappedBy = "artist")
//    private List<Track>tracks;

}
