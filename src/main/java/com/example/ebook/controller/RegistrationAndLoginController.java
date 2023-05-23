package com.example.ebook.controller;

import com.example.ebook.domain.Person;
import com.example.ebook.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationAndLoginController {

    private final PersonService personService;

    public RegistrationAndLoginController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/register")
    public String getRegistrationPage(Model model) {
        model.addAttribute("registerRequest", new Person());
        return "registrationAndLogin/registration";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new Person());
        return "registrationAndLogin/login";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Person person) {
        System.out.println("Register request " + person);
        Person registeredPerson = personService.registrationPerson(person.getName(), person.getLastName(), person.getEmail(), person.getAge(), person.getPassword());
        return registeredPerson == null ? "error/error" : "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Person person, Model model) {
        System.out.println("Login request " + person);
        Person authenticate = personService.authenticate(person.getEmail(), person.getPassword());
        if(authenticate != null) {
            model.addAttribute("userName", authenticate.getName());
            return "person/profile";
        } else {
            return "error/error";
        }
    }
}
