package com.bisoft.artistlife.ArtistProject.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Table(name = "album")
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Album {

    //    The ID for the album.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    @Column(name = "albumId")
    @Id
    private Long id;

    @Getter
    @Setter
    @Column(name = "name")
    private String name;
//
//    //  The hyper link for the Album
//    @Getter
//    @Setter
//    @Column(name = "href")
//    private String href;
//
//    //    The type of the album: one of “album”, “single”, or “compilation”.
//    @Getter
//    @Setter
//    @Column(name = "albumType")
//    private String album_type;

//    @Getter
//    @Setter
//    private List<Artist> artists;

    //İlişki kurmak gerecek
    //    The cover art for the album in various sizes, widest first.
//    @Getter
//    @Setter
//    @ManyToOne
//    @JoinColumn(name = "imagesList")
//    private List<Images> imagesList;
}
