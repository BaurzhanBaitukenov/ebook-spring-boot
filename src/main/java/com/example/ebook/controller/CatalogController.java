package com.example.ebook.controller;

import com.example.ebook.domain.Catalog;
import com.example.ebook.model.CatalogEntity;
import com.example.ebook.service.CatalogService;
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

    @GetMapping("/{id}/edit")
    public String editBookPage(@PathVariable("id") long id, Model model) {
        model.addAttribute("book", catalogService.getOneById(id));
        return "catalog/editBook";
    }

    @PostMapping("/{id}")
    public String updateBook(@PathVariable("id") long id,
                             @RequestParam String name,
                             @RequestParam String title,
                             @RequestParam String author,
                             @RequestParam String genre,
                             @RequestParam int price,
                             Model model) {
        Catalog book = catalogService.update(id, name, title, author, genre, price);
        model.addAttribute("book", book);
        return "redirect:/catalog";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") long id) {
        catalogService.deleteBookById(id);

        return "redirect:/catalog";
    }

}
