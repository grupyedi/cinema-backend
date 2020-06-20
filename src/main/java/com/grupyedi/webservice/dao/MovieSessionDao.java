package com.grupyedi.webservice.dao;

import com.grupyedi.webservice.entity.Genre;
import com.grupyedi.webservice.entity.MovieSession;

import java.util.List;

public class MovieSessionDao extends DaoManager<MovieSession> {
    /**
     * Inject the type object of T entity
     * Inject the table name of T entity
     *
     * @param type type object of T entity
     */
    public MovieSessionDao(Class<MovieSession> type) {
        super(type);
    }

    @Override
    public boolean save(MovieSession data) {
        List<MovieSession> movieSessionList = this.getAll();

        for(MovieSession ms : movieSessionList) {
            if(ms.getDate().equals(data.getDate())) {
                return false;
            }
        }

        return this.save(data);
    }
}
