package hu.unideb.inf.bootstrap_lev.controller;

import hu.unideb.inf.bootstrap_lev.model.Person;
import hu.unideb.inf.bootstrap_lev.model.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/persons/edit/{id}")
    public String editPerson(Model model, @PathVariable long id) {
        model.addAttribute("newPerson", personRepository.findById(id).get());
        model.addAttribute("titleText", "Edit Person");
        return "newPersonForm";
    }

    @GetMapping("/persons/new")
    public String addNewPerson(Model model) {
        model.addAttribute("newPerson", new Person());
        model.addAttribute("titleText", "Add New Person");
        return "newPersonForm";
    }

    @PostMapping("/persons/save")
    public String savePerson(Person person) {
        personRepository.save(person);
        return "redirect:/persons";
    }

    @GetMapping("/persons/delete/{id}")
    public String deletePerson(@PathVariable long id) {
        personRepository.deleteById(id);
        return "redirect:/persons";
    }

}

