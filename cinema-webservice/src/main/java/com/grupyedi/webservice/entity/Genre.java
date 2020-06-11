package com.grupyedi.webservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "c_name")
    public String name;
}
