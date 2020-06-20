package com.grupyedi.webservice.dao;

import com.grupyedi.webservice.entity.Genre;
import com.grupyedi.webservice.entity.Saloon;

import java.util.List;

public class SaloonDao extends DaoManager<Saloon> {
    /**
     * Inject the type object of T entity
     * Inject the table name of T entity
     *
     * @param type type object of T entity
     */
    public SaloonDao(Class<Saloon> type) {
        super(type);
    }

    @Override
    public boolean save(Saloon data) {
        List<Saloon> saloonList = this.getAll();

        for(Saloon s : saloonList) {
            if(s.getNumber() == data.getNumber()) {
                return false;
            }
        }

        return super.save(data);
    }
}
