package com.grupyedi.webservice;

import java.sql.Date;
import java.util.List;

import com.grupyedi.webservice.dao.DaoManager;
import com.grupyedi.webservice.dao.TicketDao;
import com.grupyedi.webservice.entity.Genre;
import com.grupyedi.webservice.entity.Movie;
import com.grupyedi.webservice.entity.Student;
import com.grupyedi.webservice.dao.StudentDao;
import com.grupyedi.webservice.entity.Ticket;
import com.grupyedi.webservice.util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();

        DaoManager<Movie> movieDaoManager = new DaoManager<>(Movie.class);

        Movie movie = new Movie("Foo Land", "DirectorGoo", "DirectorGoo", 12, new Date(System.currentTimeMillis()));
        movie.setGenre(new Genre("ActionFoo"));

        boolean result = movieDaoManager.save(movie);

        HibernateUtil.shutdown();
    }
}
