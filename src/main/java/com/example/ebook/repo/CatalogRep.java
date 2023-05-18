package com.example.ebook.repo;

import com.example.ebook.model.CatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRep extends JpaRepository<CatalogEntity,Long> {
}
