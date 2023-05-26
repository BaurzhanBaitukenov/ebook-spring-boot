package com.example.ebook.controller;

import com.example.ebook.domain.Person;
import com.example.ebook.service.PersonService;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationAndLoginController {

    private final PersonService personService;
    private final PasswordEncoder passwordEncoder;

    public RegistrationAndLoginController(PersonService personService) {
        this.personService = personService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // registration

    @GetMapping("/register")
    public String getRegistrationPage(Model model) {
        model.addAttribute("registerRequest", new Person());
        return "registrationAndLogin/registration";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Person person) {
        System.out.println("Register request " + person);
        Person registeredPerson = personService.registrationPerson(person.getName(), person.getLastName(), person.getEmail(), person.getAge(), person.getPassword());
        return registeredPerson == null ? "error/error" : "redirect:/login";
    }



    //login

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new Person());
        return "registrationAndLogin/login";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute Person person, HttpSession session) {
        System.out.println("Login request " + person);
//        String encoded = this.passwordEncoder.encode(person.getPassword());

        Person authenticate = personService.authenticate(person.getEmail(), person.getPassword());
        if (authenticate != null) {
            session.setAttribute("user", authenticate);
            return "redirect:/profile";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/profile")
    public String showProfilePage(HttpSession session, Model model) {
        Person person = (Person) session.getAttribute("user");
        if (person != null) {
            model.addAttribute("user", person);
            return "person/profile";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Invalidate the session to remove the user attribute
        return "redirect:/login";
    }

}
