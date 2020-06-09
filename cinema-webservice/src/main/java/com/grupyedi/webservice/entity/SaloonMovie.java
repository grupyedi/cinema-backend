package com.grupyedi.webservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_purchase")
public class SaloonMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "c_saloon")
    public Saloon saloon;

    @Column(name = "c_movie")
    public Movie movie;
}
