package com.bisoft.artistlife.ArtistProject.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;


import javax.persistence.*;
import java.util.List;

@Table(name = "followers")
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

    @JsonBackReference
    @ManyToMany(mappedBy = "followers")
    private List<Album> albums;

//    @Getter
//    @Setter
//    @ManyToMany(mappedBy = "followers")
//    private List<Album> albums;


}
