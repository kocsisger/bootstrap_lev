package hu.unideb.inf.bootstrap_lev.controller;

import hu.unideb.inf.bootstrap_lev.model.Person;
import hu.unideb.inf.bootstrap_lev.model.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    PersonRepository personRepository;

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/persons")
    public String getAllPersons(Model model) {
        model.addAttribute("personsList", personRepository.findAll());
        return "persons";
    }

    @GetMapping("/persons/new")
    public String addNewPerson(Model model) {
        model.addAttribute("newPerson", new Person());
        return "newPersonForm";
    }

}

