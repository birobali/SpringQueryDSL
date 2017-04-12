package com.birobali.adapter.persistence;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Balázs on 2017.04.12..
 */
public interface PersonRepository extends CrudRepository<Person, String>, QueryDslPredicateExecutor<Person>/*, QuerydslBinderCustomizer<QPerson>*/ {

}
