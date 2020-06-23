package com.grupyedi.webservice.server;

import com.grupyedi.webservice.dao.*;
import com.grupyedi.webservice.entity.*;
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
        api.get("/movie-sessions", this::getMovieSessions);
        api.get("/genres", this::getGenres);
        api.get("/saloons", this::getSaloons);
        api.get("/tickets", this::getTickets);
        api.post("/users/register", this::createUser);
        api.post("/users/login", this::loginUser);
        api.post("/tickets/purchase", this::purchaseTicket);
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

    private void getMovieSessions(Context ctx) {
        MovieSessionDao movieSessionDao = new MovieSessionDao(MovieSession.class);

        List<MovieSession> movieSessions = movieSessionDao.getAll();

        if(movieSessions == null) {
            ctx.status(400);
            return;
        } else {
            ctx.json(movieSessions);
        }
    }

    private void getGenres(Context ctx) {
        GenreDao genreDao = new GenreDao(Genre.class);

        List<Genre> genreList = genreDao.getAll();

        if(genreList == null) {
            ctx.status(400);
        } else {
            ctx.json(genreList);
        }
    }

    private void getTickets(Context ctx) {
        DaoManager<Ticket> ticketDao = new DaoManager<>(Ticket.class);

        List<Ticket> ticketList = ticketDao.getAll();

        if(ticketList == null) {
            ctx.status(400);
        } else {
            ctx.json(ticketList);
        }
    }

    private void getSaloons(Context ctx) {
        SaloonDao saloonDao = new SaloonDao(Saloon.class);

        List<Saloon> saloonList = saloonDao.getAll();

        if(saloonList == null) {
            ctx.status(400);
            return;
        } else {
            ctx.json(saloonList);
        }
    }

    private void createUser(Context ctx) {
        UserDao userDao = new UserDao(User.class);

        String gsm = (String) ctx.req.getAttribute("gsm");
        String email = (String) ctx.req.getAttribute("email");
        String password = (String) ctx.req.getAttribute("password");
        String firstName = (String) ctx.req.getAttribute("firstname");
        String lastName = (String) ctx.req.getAttribute("lastname");
        int age = (int) ctx.req.getAttribute("age");

        User user = new User(gsm,  email,  password, firstName, lastName, age);

        boolean success = userDao.save(user);
        if(success) {
            ctx.status(200);
        } else {
            ctx.status(403);
        }
    }

    private void loginUser(Context ctx) {
        UserDao userDao = new UserDao(User.class);

        List<User> userList = userDao.getAll();
        String gsm = (String) ctx.req.getAttribute("gsm");
        String password = (String) ctx.req.getAttribute("password");

        for(User user: userList) {
            if(user.getGsm().equals(gsm)) {
                if(user.getPassword().equals(password)) {
                    ctx.status(200);
                    return;
                } else {
                    ctx.status(403);
                    return;
                }
            }
        }

        ctx.status(404);
        return;
    }

    private void purchaseTicket(Context ctx) {
        DaoManager<Ticket> ticketDao = new DaoManager<>(Ticket.class);
        DaoManager<Purchase> purchaseDaoManager = new DaoManager<>(Purchase.class);
        UserDao userDao = new UserDao(User.class);
        MovieSessionDao movieSessionDao = new MovieSessionDao(MovieSession.class);

        int ticketId = (int) ctx.req.getAttribute("ticket-id");
        int userId = (int) ctx.req.getAttribute("user-id");
        int movieSessionId = (int) ctx.req.getAttribute("movie-session-id");

        Ticket ticket = ticketDao.get(ticketId);
        User user = userDao.get(userId);
        MovieSession movieSession = movieSessionDao.get(movieSessionId);

        if(ticket == null || user == null || movieSession == null) {
            ctx.status(400);
            return;
        }

        Purchase purchase = new Purchase();
        purchase.setTicket(ticket);
        purchase.setUser(user);
        purchase.setMovie(movieSession);

        boolean result = purchaseDaoManager.save(purchase);
        if(result) {
            ctx.status(200);
        } else {
            ctx.status(400);
        }
    }
}
