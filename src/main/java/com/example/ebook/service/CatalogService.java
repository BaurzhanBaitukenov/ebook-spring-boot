package com.example.ebook.service;

import com.example.ebook.domain.Catalog;
import com.example.ebook.mapper.Mapper;
import com.example.ebook.model.CatalogEntity;
import com.example.ebook.repo.CatalogRep;
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

    public Catalog update(long id, String name, String title, String author, String genre, int price) {
        CatalogEntity catalogEntity = catalogRep.findById(id).orElseThrow();
        catalogEntity.setName(name);
        catalogEntity.setTitle(title);
        catalogEntity.setAuthor(author);
        catalogEntity.setGenre(genre);
        catalogEntity.setPrice(price);
        CatalogEntity updatedCatalogEntity = catalogRep.save(catalogEntity);
        return mapper.mapCatalog(updatedCatalogEntity);
    }
}
