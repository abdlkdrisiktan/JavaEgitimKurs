package com.bisoft.artistlife.ArtistProject.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Table(name = "followers")
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Followers {


    @Getter
    @Setter
    @Column(name = "followersId")
    @Id
    private Long id;

    @Getter
    @Setter
    @Column(name = "total")
    private int total;

    @Getter
    @Setter
    @ManyToMany(mappedBy = "followers")
    private List<Album> albums;


}
