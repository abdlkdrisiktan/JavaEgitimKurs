package com.bisoft.artistlife.ArtistProject.entity;


import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@EntityListeners(AuditingEntityListener.class)
@Table(name = "track")
@Data
@Entity
public class Track {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private String name;

    private String href;

    private int durationMs;

    @ManyToOne
    private Artist artist;

    @ManyToOne
    private Album album;

}
