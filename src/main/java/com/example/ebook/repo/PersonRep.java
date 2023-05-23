package com.example.ebook.repo;

import com.example.ebook.domain.Person;
import com.example.ebook.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRep extends JpaRepository<PersonEntity,Long> {
    Optional<PersonEntity> findPersonEntityByEmailAndPassword(String email, String password);
}
