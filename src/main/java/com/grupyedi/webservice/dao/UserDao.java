package com.grupyedi.webservice.dao;

import com.grupyedi.webservice.entity.Genre;
import com.grupyedi.webservice.entity.User;

import java.util.List;

public class UserDao extends DaoManager<User> {
    /**
     * Inject the type object of T entity
     * Inject the table name of T entity
     *
     * @param type type object of T entity
     */
    public UserDao(Class<User> type) {
        super(type);
    }

    @Override
    public boolean save(User data) {
        List<User> userList = this.getAll();

        for(User u : userList) {
            if(u.getGsm().equals(data.getGsm())) {
                return false;
            }
        }

        return super.save(data);
    }
}
