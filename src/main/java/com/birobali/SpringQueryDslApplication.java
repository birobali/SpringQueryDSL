package com.birobali;

import com.birobali.adapter.persistence.Person;
import com.birobali.adapter.persistence.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableWebMvc
@EnableSpringDataWebSupport
public class SpringQueryDslApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringQueryDslApplication.class, args);
	}

	@Autowired
	private PersonRepository personRepository;

	@PostConstruct
	public void init(){
		Person person = new Person();
		person.setFirstName("Kati");
		person.setLastName("Horvath");
		personRepository.save(person);
	}
}
