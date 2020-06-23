package com.grupyedi.webservice.server;

import com.grupyedi.webservice.dao.GenreDao;
import com.grupyedi.webservice.dao.MovieDao;
import com.grupyedi.webservice.entity.Genre;
import com.grupyedi.webservice.entity.Movie;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiHandler {
    private final Javalin api;

    public ApiHandler(Javalin api) {
        this.api = api;
    }

    public void initializeApi() {
        api.get("/movies", this::getMovies);
    }

    private void getMovies(Context ctx) {
        MovieDao movieDao = new MovieDao(Movie.class);
        GenreDao genreDao = new GenreDao(Genre.class);

        List<Movie> movies = movieDao.getAll();

        if(movies == null) {
            ctx.status(400);
            return;
        }

        Map<String, List<Movie>> map = new HashMap<>();
        for(Movie movie : movies) {
            List<Movie> foundList = map.get(movie.getGenre().getName());
            if(foundList != null) {
                foundList.add(movie);
            } else {
                List<Movie> createdList = new ArrayList<>();
                createdList.add(movie);
                map.put(movie.getGenre().getName(), createdList);
            }
        }

        ctx.json(map);
    }
}
