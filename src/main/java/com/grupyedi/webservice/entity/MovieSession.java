package com.grupyedi.webservice.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "MovieSession")
public class MovieSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "saloon_id")
    private Saloon saloon;

    @ManyToOne()
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Column(name = "date")
    private Date date;

    public MovieSession() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Saloon getSaloon() {
        return saloon;
    }

    public void setSaloon(Saloon saloon) {
        this.saloon = saloon;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
