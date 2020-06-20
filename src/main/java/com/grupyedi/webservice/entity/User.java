package com.grupyedi.webservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_user")
public class User {
    @Id
    @Column(name = "c_gsm")
    public String gsm;

    @Column(name = "c_email")
    public String email;

    @Column(name = "c_password")
    public String password;

    @Column(name = "c_first_name")
    public String firstName;

    @Column(name = "c_surname")
    public String surname;

    //TODO: purchase history id list


    @Column(name = "c_age")
    public int age;
}
