package com.birobali.adapter.controller;

import com.birobali.adapter.persistence.Person;
import com.birobali.adapter.persistence.PersonRepository;
import com.birobali.adapter.persistence.QPerson;
import com.querydsl.core.types.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by Balázs on 2017.04.12..
 */
@RestController
@Slf4j
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping(value = "/api/persons", produces = APPLICATION_JSON_VALUE)
    public @ResponseBody String persons(@QuerydslPredicate(root = Person.class) Predicate predicate) {
        return personRepository.findAll(predicate).toString();
    }

    @GetMapping(value = "/api/persons/searchByFirstName/{firstName}", produces = APPLICATION_JSON_VALUE)
    public @ResponseBody String personsFirstName(@PathVariable("firstName") String firstName) {
        Predicate predicate = QPerson.person.firstName.eq(firstName);
        log.info(firstName);
        return personRepository.findAll(predicate).toString();
    }
}
