package br.com.sysled.restapi.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.sysled.restapi.model.Person;

@Service
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	public Person findById(String id) {
		
		logger.info("Buscando pessoa:");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirtsName("Kevin");
		person.setLastName("Mendes");
		person.setAddress("Pirambu, Fortal");
		person.setGender("M");
		
		return person;
		
	}	
	
	
}
