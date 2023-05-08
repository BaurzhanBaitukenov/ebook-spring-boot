package com.example.ebook.controller;

import com.example.ebook.domain.Person;
import com.example.ebook.model.PersonEntity;
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

    @GetMapping("/list/{id}")
    public String getPersonById(@PathVariable("id") long id, Model model) {
        Person person = personService.getOneById(id);
        model.addAttribute("person", person);
        return "personById";
    }

    @GetMapping("/list/{id}/edit")
    public String editPerson(Model model, @PathVariable("id") long id) {
        model.addAttribute("person", personService.getOneById(id));

        return "editPerson";
    }

    @PostMapping("/update/{id}")
    public String updatePerson(@PathVariable("id") long id, @ModelAttribute("person") Person updatedPerson) {


        return "redirect:/person/list";
    }

    @GetMapping("/new")
    public String createNewPerson(Model model) {
        model.addAttribute("person", new PersonEntity());
        return "newPerson";
    }

    @PostMapping("/create")
    public String createPerson(@ModelAttribute("person")PersonEntity personEntity) {
        personService.createPerson(personEntity);
        return "redirect:/person/list";
    }


    @DeleteMapping ("/list/{id}")
    public String deletePerson(@PathVariable("id") long id) {
        personService.deletePersonById(id);
        return "redirect:/person/list";
    }

}
