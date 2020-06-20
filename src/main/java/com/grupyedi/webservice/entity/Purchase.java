package com.grupyedi.webservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Ticket.class)
    @JoinColumn(name = "c_ticket_id")
    public Ticket ticket;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "c_movie_id", table = "t_movie")
    public Movie movie;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Saloon.class)
    @JoinColumn(name = "c_saloon_id")
    public Saloon saloon;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = "c_user_id")
    public User user;
}
