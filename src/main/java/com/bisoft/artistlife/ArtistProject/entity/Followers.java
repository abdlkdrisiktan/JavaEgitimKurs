package com.bisoft.artistlife.ArtistProject.entity;


import lombok.Data;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Table(name = "followers")
@EntityListeners(AuditingEntityListener.class)
@Data
@Entity
public class Followers {

     //    The ID for the Followers.
    @Column(name = "followers_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // Follower name
    @Column(name = "total")
    private String name;


    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "followers")
    private List<Album> albums;

//    @Getter
//    @Setter
//    @ManyToMany(mappedBy = "followers")
//    private List<Album> albums;


}
