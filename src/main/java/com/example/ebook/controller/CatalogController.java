package com.example.ebook.controller;

import com.example.ebook.domain.Catalog;
import com.example.ebook.model.CatalogEntity;
import com.example.ebook.model.PersonEntity;
import com.example.ebook.service.CatalogService;
import com.example.ebook.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping
    public String listOfAllBooks(Model model) {
        List<Catalog> books = catalogService.getAll();
        model.addAttribute("books", books);
        return "catalog/mainCatalog";
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable("id") long id, Model model) {
        Catalog book = catalogService.getOneById(id);
        model.addAttribute("book", book);
        return "catalog/bookById";
    }

    @GetMapping("/new")
    public String createBook(Model model) {
        model.addAttribute("book", new CatalogEntity());
        return "catalog/newBook";
    }

    @PostMapping("/create")
    public String createNewBook(@ModelAttribute("book") CatalogEntity catalogEntity) {
        catalogService.createBook(catalogEntity);
        return "redirect:/catalog";
    }

}
