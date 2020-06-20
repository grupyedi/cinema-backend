package com.grupyedi.webservice.dao;

import com.grupyedi.webservice.entity.Genre;

import java.util.List;

public class GenreDao extends DaoManager<Genre> {
    /**
     * Inject the type object of T entity
     * Inject the table name of T entity
     *
     * @param type type object of T entity
     */
    public GenreDao(Class<Genre> type) {
        super(type);
    }

    @Override
    public boolean save(Genre data) {
        List<Genre> genreList = this.getAll();

        for(Genre g : genreList) {
            if(g.getName().equals(data.getName())) {
                return false;
            }
        }

        return this.save(data);
    }
}
