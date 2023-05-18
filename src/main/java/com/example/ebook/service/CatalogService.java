package com.example.ebook.service;

import com.example.ebook.domain.Catalog;
import com.example.ebook.domain.Person;
import com.example.ebook.mapper.Mapper;
import com.example.ebook.model.CatalogEntity;
import com.example.ebook.model.PersonEntity;
import com.example.ebook.repo.CatalogRep;
import com.example.ebook.repo.PersonRep;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatalogService {

    private final CatalogRep catalogRep;
    private final Mapper mapper;

    public CatalogService(CatalogRep catalogRep, Mapper mapper) {
        this.catalogRep = catalogRep;
        this.mapper = mapper;
    }

    public List<Catalog> getAll() {
        List<CatalogEntity> catalogEntities = catalogRep.findAll();
        return catalogEntities.stream()
                .map(catalogEntity -> mapper.mapCatalog(catalogEntity))
                .collect(Collectors.toList());
    }

    public Catalog getOneById(long id) {
        CatalogEntity catalogEntity = catalogRep.findById(id).orElseThrow();
        return mapper.mapCatalog(catalogEntity);
    }

    public void createBook(CatalogEntity catalogEntity) {
        catalogRep.save(catalogEntity);
    }
}
