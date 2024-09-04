package br.com.erudio8.services;

import br.com.erudio8.exceptions.ResourceNotFoundException;
import br.com.erudio8.model.Person;
import br.com.erudio8.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    private PersonRepository repository;

    public List<Person> findAll() {
        logger.info("Finding all people!");

        return repository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Finding one person!");

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
    }

    public Person create(Person person) {
        logger.info("Create one person!");

        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("Updating one person!");

        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        repository.delete(entity);
    }
}
