package hu.unideb.inf.lev.bootstrap_lev.controller;

import hu.unideb.inf.lev.bootstrap_lev.model.Person;
import hu.unideb.inf.lev.bootstrap_lev.model.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    @GetMapping("")
    public String showHomePage(){
        return "index";
    }

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/persons")
    public String getAllPersons(Model model){
        List<Person> personsList = personRepository.findAll();
        model.addAttribute("personsList", personsList);
        return "persons";
    }
}
