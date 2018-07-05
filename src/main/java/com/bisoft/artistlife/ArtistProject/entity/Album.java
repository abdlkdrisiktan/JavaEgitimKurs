package com.bisoft.artistlife.ArtistProject.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Table(name = "album")
@EntityListeners(AuditingEntityListener.class)
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

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "album_followers",joinColumns = {@JoinColumn(name = "album_id")},
    inverseJoinColumns = {@JoinColumn(name = "followers_id")})
    private List<Followers> followers;

//    @ManyToOne
//    private Artist artist;
//
//    @OneToMany(mappedBy = "album")
//    private List<Track> tracks;
}
