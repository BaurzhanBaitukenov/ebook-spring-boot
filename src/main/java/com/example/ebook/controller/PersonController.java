package com.example.ebook.controller;

import com.example.ebook.domain.Person;
import com.example.ebook.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/person")
@Controller
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/list")
    public String listOfAllPerson(Model model) {
        List<Person> persons = personService.getAll();
        model.addAttribute("persons", persons);
        return "person";
    }

//    @DeleteMapping ("/list")
//    public void deletePerson(@RequestParam Integer id) {
//        personService.deletePersonById(id);
////        return "redirect:/list";
//    }
}
