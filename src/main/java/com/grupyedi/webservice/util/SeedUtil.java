package com.grupyedi.webservice.util;

import com.grupyedi.webservice.dao.*;
import com.grupyedi.webservice.entity.*;

import java.sql.Date;

public class SeedUtil {

    public static void seedDb() {
        UserDao userDao = new UserDao(User.class);
        GenreDao genreDao = new GenreDao(Genre.class);
        MovieDao movieDao = new MovieDao(Movie.class);
        SaloonDao saloonDao = new SaloonDao(Saloon.class);
        MovieSessionDao movieSessionDao = new MovieSessionDao(MovieSession.class);
        DaoManager<Ticket> ticketDaoManager = new DaoManager<>(Ticket.class);
        DaoManager<Purchase> purchaseDaoManager = new DaoManager<>(Purchase.class);

        User user1 = new User("+900001", "foo@foo.com", "1234", "foo", "fooSir", 18);
        User user2 = new User("+900002", "goo@goo.com", "1234", "goo", "gooSir", 24);

        userDao.save(user1);
        userDao.save(user2);

        Genre action = new Genre("action");
        Genre adventure = new Genre("adventure");
        Genre crime = new Genre("crime");
        Genre mystery = new Genre("mystery");
        Genre scifi = new Genre("sci-fi");
        Genre drama = new Genre("drama");

        genreDao.save(action);
        genreDao.save(adventure);
        genreDao.save(crime);
        genreDao.save(mystery);
        genreDao.save(scifi);
        genreDao.save(drama);

        Movie movie1 = new Movie("The Shawshank Redemption", "Chronicles the experiences of a formerly successful banker as a prisoner in the gloomy jailhouse of Shawshank after being found guilty of a crime he did not commit. The film portrays the man's unique way of dealing with his new, torturous life; along the way he befriends a number of fellow prisoners, most notably a wise long-term inmate named Red. Written by J-S-Golden", "Frank Darabont", 18, new Date(System.currentTimeMillis()), "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UY1200_CR89,0,630,1200_AL_.jpg");
        movie1.setGenre(drama);
        Movie movie2 = new Movie("The Godfather", "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.", "Francis Ford Coppola", 18, new Date(System.currentTimeMillis()), "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg");
        movie2.setGenre(crime);
        Movie movie3 = new Movie("The Dark Knight", "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.", "Christopher Nolan", 18, new Date(System.currentTimeMillis()), "https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_.jpg");
        movie3.setGenre(action);
        Movie movie4 = new Movie("Schindler's List", "In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis.", "Steven Spielberg", 18, new Date(System.currentTimeMillis()), "https://m.media-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_.jpg");
        movie4.setGenre(drama);
        Movie movie5 = new Movie("Inception", "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.", "Christopher Nolan", 18, new Date(System.currentTimeMillis()), "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_UY1200_CR90,0,630,1200_AL_.jpg");
        movie5.setGenre(scifi);

        movieDao.save(movie1);
        movieDao.save(movie2);
        movieDao.save(movie3);
        movieDao.save(movie4);
        movieDao.save(movie5);

        Saloon saloon1 = new Saloon(1, 90, "Medium sized saloon with next gen sound systems!");
        Saloon saloon2 = new Saloon(2, 150, "Huge system setup for your pleasure with IMAX!");
        Saloon saloon3 = new Saloon(3, 25, "Why?");

        saloonDao.save(saloon1);
        saloonDao.save(saloon2);
        saloonDao.save(saloon3);

        MovieSession movieSession1 = new MovieSession();
        movieSession1.setSaloon(saloon1);
        movieSession1.setMovie(movie1);
        movieSession1.setDate(new Date(System.currentTimeMillis()));

        MovieSession movieSession2 = new MovieSession();
        movieSession2.setSaloon(saloon2);
        movieSession2.setMovie(movie4);
        movieSession2.setDate(new Date(System.currentTimeMillis()));

        MovieSession movieSession3 = new MovieSession();
        movieSession3.setSaloon(saloon3);
        movieSession3.setMovie(movie5);
        movieSession3.setDate(new Date(System.currentTimeMillis()));

        movieSessionDao.save(movieSession1);
        movieSessionDao.save(movieSession2);
        movieSessionDao.save(movieSession3);

        Ticket ticket1 = new Ticket(20, "Student Ticket", 10);
        Ticket ticket2 = new Ticket(50, "Luxury Ticket", -10);
        Ticket ticket3 = new Ticket(30, "Regular Ticket", 0);

        ticketDaoManager.save(ticket1);
        ticketDaoManager.save(ticket2);
        ticketDaoManager.save(ticket3);

        Purchase purchase1 = new Purchase();
        purchase1.setMovie(movieSession2);
        purchase1.setTicket(ticket1);
        purchase1.setUser(user1);

        Purchase purchase2 = new Purchase();
        purchase2.setTicket(ticket3);
        purchase2.setUser(user2);
        purchase2.setMovie(movieSession3);

        purchaseDaoManager.save(purchase1);
        purchaseDaoManager.save(purchase2);
    }

}
