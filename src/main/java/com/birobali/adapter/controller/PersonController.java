package com.birobali.adapter.controller;

import com.birobali.adapter.persistence.Person;
import com.birobali.adapter.persistence.PersonRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by Balázs on 2017.04.12..
 */
@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping(value = "/persons", produces = APPLICATION_JSON_VALUE)
    public @ResponseBody String persons(@QuerydslPredicate(root = Person.class) Predicate predicate) {
        return personRepository.findAll(predicate).toString();
    }
}
