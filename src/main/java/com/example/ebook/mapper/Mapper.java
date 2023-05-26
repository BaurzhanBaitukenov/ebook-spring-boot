package com.example.ebook.mapper;

import com.example.ebook.domain.Catalog;
import com.example.ebook.domain.Person;
import com.example.ebook.model.CatalogEntity;
import com.example.ebook.model.PersonEntity;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public Person mapPerson(PersonEntity personEntity) {
        if(personEntity == null) {
            return null;
        }

        Person result = new Person(personEntity.getId(), personEntity.getName(), personEntity.getLastName(), personEntity.getEmail(),
                personEntity.getPassword(), personEntity.getAge(), personEntity.getRole());

        return result;
    }

    public Catalog mapCatalog(CatalogEntity catalogEntity) {
        if(catalogEntity == null) {
            return null;
        }

        Catalog result = new Catalog(catalogEntity.getId(), catalogEntity.getName(), catalogEntity.getTitle(), catalogEntity.getAuthor(), catalogEntity.getGenre(),catalogEntity.getPrice(), catalogEntity.getImageUrl());

        return result;
    }
}
