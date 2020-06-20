package com.grupyedi.webservice.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "saloon")
public class Saloon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "number")
    private int number;

    @Column(name = "capacity")
    private int capacity;

    //TODO: Layout logic

    //TODO: add available tickets as a list

    @Column(name = "description")
    private String description;

    //TODO: add movie sessions as a list

    public Saloon() {}

    public Saloon(int number, int capacity, String description) {
        this.number = number;
        this.capacity = capacity;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
