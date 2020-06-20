package com.grupyedi.webservice.dao;

import com.grupyedi.webservice.entity.Genre;
import com.grupyedi.webservice.entity.Movie;

import java.util.List;

public class MovieDao extends DaoManager<Movie> {
    /**
     * Inject the type object of T entity
     * Inject the table name of T entity
     *
     * @param type type object of T entity
     */
    public MovieDao(Class<Movie> type) {
        super(type);
    }

    @Override
    public boolean save(Movie data) {
        List<Movie> movieList = this.getAll();

        for(Movie m : movieList) {
            if(m.getName().equals(data.getName())) {
                return false;
            }
        }

        return super.save(data);
    }
}
