package com.grupyedi.webservice;

import java.sql.Date;
import java.util.List;

import com.grupyedi.webservice.dao.DaoManager;
import com.grupyedi.webservice.dao.TicketDao;
import com.grupyedi.webservice.entity.*;
import com.grupyedi.webservice.dao.StudentDao;
import com.grupyedi.webservice.util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();

        DaoManager<Movie> movieDaoManager = new DaoManager<>(Movie.class);
        DaoManager<MovieSession> movieSessionDaoManager = new DaoManager<>(MovieSession.class);
        DaoManager<Saloon> saloonDaoManager = new DaoManager<>(Saloon.class);

        Movie movie = new Movie("Foo Land", "DirectorGoo", "DirectorGoo", 12, new Date(System.currentTimeMillis()));
        movie.setGenre(new Genre("ActionFoo"));

        boolean result = movieDaoManager.save(movie);

        Saloon saloonFoo = new Saloon(1, 15, "Saloon 1");
        saloonDaoManager.save(saloonFoo);

        List<Movie> movies = movieDaoManager.getAll();
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movies.get(0));
        movieSession.setSaloon(saloonFoo);
        movieSession.setDate(new Date(System.currentTimeMillis()));

        movieSessionDaoManager.save(movieSession);

        HibernateUtil.shutdown();
    }
}
