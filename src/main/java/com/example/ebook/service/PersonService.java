package com.example.ebook.service;

import com.example.ebook.domain.Person;
import com.example.ebook.mapper.Mapper;
import com.example.ebook.model.PersonEntity;
import com.example.ebook.repo.PersonRep;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRep personRep;
    private final PasswordEncoder passwordEncoder;
    private final Mapper mapper;


    public PersonService(PersonRep personRep, Mapper mapper) {
        this.personRep = personRep;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.mapper = mapper;
    }

    public List<Person> getAll() {
        List<PersonEntity> personEntities = personRep.findAll();
        return personEntities.stream()
                .map(personEntity -> mapper.mapPerson(personEntity))
                .collect(Collectors.toList());
    }

    public void deletePersonById(long id) {
        PersonEntity personEntity = personRep.findById(id).orElseThrow();
        personRep.delete(personEntity);
    }

    public Person getOneById(long id) {
        PersonEntity personEntity = personRep.findById(id).orElseThrow(() -> new IllegalArgumentException("Person not found by id: " + id));
        return mapper.mapPerson(personEntity);
    }

    public void createPerson(PersonEntity personEntity) {
        String encodedPassword = this.passwordEncoder.encode(personEntity.getPassword());
        personEntity.setPassword(encodedPassword);
        personRep.save(personEntity);
    }

    public Person update(long id, String name, String lastName, String email, String password, int age) {
        PersonEntity personEntity = personRep.findById(id).orElseThrow();
        personEntity.setName(name);
        personEntity.setLastName(lastName);
        personEntity.setEmail(email);
        personEntity.setPassword(password);
        personEntity.setAge(age);

        PersonEntity updatedPerson = personRep.save(personEntity);
        return mapper.mapPerson(updatedPerson);
    }
}
