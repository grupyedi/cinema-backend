package com.grupyedi.webservice.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "banner_url")
    private String bannerUrl;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @Column(name = "summary", length = 1000)
    private String summary;

    @Column(name = "director")
    private String director;

    // TODO: add actors as list

    @Column(name = "ageRating")
    private int ageRating;

    @Column(name = "releaseDate")
    private Date releaseDate;

    public Movie() {}

    public Movie(String name, String summary, String director, int ageRating, Date releaseDate, String bannerUrl) {
        this.name = name;
        this.summary = summary;
        this.director = director;
        this.ageRating = ageRating;
        this.releaseDate = releaseDate;
        this.bannerUrl = bannerUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }
}
