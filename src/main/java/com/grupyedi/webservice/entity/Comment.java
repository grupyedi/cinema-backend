package com.grupyedi.webservice.entity;

import com.grupyedi.webservice.other.Rating;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private Date date;

    /**
     * Its getter method does a slightly different job than a 'normal' getter.
     */
    @Column(name = "rating")
    private Rating rating;

    @Column(name = "content")
    public String content;

    @ManyToOne()
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    public Comment(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRating() {
        return rating.getVal();
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
