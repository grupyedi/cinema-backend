package com.grupyedi.webservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @OneToMany()
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Saloon.class)
    @JoinColumn(name = "c_saloon_id")
    public Saloon saloon;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = "c_user_id")
    public User user;
}
