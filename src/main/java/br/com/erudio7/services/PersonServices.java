package br.com.erudio7.services;

import br.com.erudio7.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id) {
        logger.info("Finding one person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("William");
        person.setLastName("Santana");
        person.setAddress("Aracaju - Sergipe - Brazil");
        person.setGender("Male");

        return person;
    }
}
