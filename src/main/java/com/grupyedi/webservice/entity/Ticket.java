package com.grupyedi.webservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "c_price")
    public double price;

    @Column(name = "c_description")
    public String description;

    @Column(name = "c_discountRate", nullable = false)
    public double discountRate;

    public Ticket(double price, String description, double discountRate) {
        this.price = price;
        this.description = description;
        this.discountRate = discountRate;
    }

    public Ticket() {}
}
