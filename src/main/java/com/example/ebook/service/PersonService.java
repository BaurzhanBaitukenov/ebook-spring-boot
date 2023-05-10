package com.example.ebook.service;

import com.example.ebook.domain.Person;
import com.example.ebook.mapper.Mapper;
import com.example.ebook.model.PersonEntity;
import com.example.ebook.repo.PersonRep;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRep personRep;
    private final Mapper mapper;

    public PersonService(PersonRep personRep, Mapper mapper) {
        this.personRep = personRep;
        this.mapper = mapper;
    }

    public List<Person> getAll() {
        List<PersonEntity> personEntities = personRep.findAll();
        return personEntities.stream()
                .map(personEntity -> mapper.map(personEntity))
                .collect(Collectors.toList());
    }

    public void deletePersonById(long id) {
        personRep.deletePersonEntityById(id);
    }

    public Person getOneById(long id) {
        PersonEntity personEntity = personRep.findById(id).orElseThrow(() -> new IllegalArgumentException("Person not found by id: " + id));
        return mapper.map(personEntity);
    }

    public void createPerson(PersonEntity personEntity) {
        personRep.save(personEntity);
    }

    public Person update(PersonEntity personEntity) {
        return null;
    }
}
