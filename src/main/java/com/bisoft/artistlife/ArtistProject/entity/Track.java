package com.bisoft.artistlife.ArtistProject.entity;


import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Table(name = "track")
@Data
@Entity
public class Track {

    //  The ID for the Track
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    //  The name for the Track
    private String name;

    //  The hyper link for the Album
    private String href;

    //  The duration for the Track
    private int durationMs;

//    @ManyToOne
//    private Artist artist;

    @ManyToOne
    private Album album;

}
