package com.grupyedi.webservice.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "t_movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "c_name")
    public String name;

    @Column(name = "c_banner_urls")
    @ElementCollection(targetClass = String.class)
    public List<String> bannersUrls;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "c_genre_id")
    public Genre genre;

    @Column(name = "c_summary")
    public String summary;

    @Column(name = "c_director")
    public String director;

    @Column(name = "c_actors")
    @ElementCollection(targetClass = String.class)
    public List<String> actors;

    @Column(name = "c_age_rating")
    public int ageRating;

    @Column(name = "c_release_date")
    public Date releaseDate;
}
