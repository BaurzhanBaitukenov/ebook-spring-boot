package com.example.ebook.controller;

import com.example.ebook.domain.Person;
import com.example.ebook.model.PersonEntity;
import com.example.ebook.service.PersonService;
import org.springframework.security.crypto.password.PasswordEncoder;
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
        return "person/person";
    }

    @GetMapping("/list/{id}")
    public String getPersonById(@PathVariable("id") long id, Model model) {
        Person person = personService.getOneById(id);
        model.addAttribute("person", person);
        return "person/personById";
    }

    @GetMapping("/list/{id}/edit")
    public String editPerson(Model model, @PathVariable("id") long id) {
        model.addAttribute("person", personService.getOneById(id));

        return "person/editPerson";
    }

    @PostMapping("/{id}")
    public String updatePerson(@PathVariable("id") long id,
                               @RequestParam String name,
                               @RequestParam String lastName,
                               @RequestParam String email,
                               @RequestParam String password,
                               @RequestParam int age,
                               Model model) {

        Person updatedPerson = personService.update(id, name, lastName, email, password, age);
        model.addAttribute("person", updatedPerson);
        return "redirect:/person/list";
    }

    @GetMapping("/new")
    public String createNewPerson(Model model) {
        model.addAttribute("person", new PersonEntity());
        return "person/newPerson";
    }

    @PostMapping("/create")
    public String createPerson(@ModelAttribute("person")PersonEntity personEntity) {
        personService.createPerson(personEntity);
        return "redirect:/person/list";
    }


    @PostMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") long id) {
        personService.deletePersonById(id);
        return "redirect:/person/list";
    }

}
