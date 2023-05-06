package com.example.ebook.mapper;

import com.example.ebook.domain.Person;
import com.example.ebook.model.PersonEntity;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public Person map(PersonEntity personEntity) {
        if(personEntity == null) {
            return null;
        }

        Person result = new Person(personEntity.getId(), personEntity.getName(), personEntity.getLastName(), personEntity.getEmail(),
                personEntity.getPassword(), personEntity.getAge());

        return result;
    }
}
