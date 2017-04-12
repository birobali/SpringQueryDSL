package com.birobali.adapter.persistence;

import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Balázs on 2017.04.12..
 */
@Entity
@Setter
@ToString
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    String id;
    String firstName;
    String lastName;

}
