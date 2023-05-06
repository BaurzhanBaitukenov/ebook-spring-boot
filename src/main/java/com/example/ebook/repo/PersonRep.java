package com.example.ebook.repo;

import com.example.ebook.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRep extends JpaRepository<PersonEntity,Long> {


}
