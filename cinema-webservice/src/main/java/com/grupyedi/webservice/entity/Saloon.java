package com.grupyedi.webservice.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_saloon")
public class Saloon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "c_number")
    public int number;

    @Column(name = "c_capacity")
    public int capacity;

    //TODO: Layout logic

    @Column(name = "c_tickets")
    @ElementCollection(targetClass = Ticket.class)
    public List<Ticket> tickets;

    @Column(name = "c_cinemaInfo")
    public String cinemaInfo;

    @Column(name = "c_movies")
    @ElementCollection(targetClass = SaloonMovie.class)
    public List<SaloonMovie> movies;
}
