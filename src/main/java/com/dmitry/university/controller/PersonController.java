package com.dmitry.university.controller;


import com.dmitry.university.model.person.Person;
import com.dmitry.university.service.PersonService;
import com.dmitry.university.service.PersonServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@RequestMapping("/person")
public class PersonController {

    private PersonServiceImpl personService;

    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }


    @GetMapping("")
    public String getPersons(HttpServletRequest request, Model theModel){
        int page = 0; //default page number
        int size = 5; // default page size

        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
            page = Integer.parseInt(request.getParameter("page")) - 1;
        }

        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
            size = Integer.parseInt(request.getParameter("size"));
        }
        Page<Person> personsList = personService.findAll(page, size);
        theModel.addAttribute("personsList", personsList);
        return "/person/person";
    }

    @PostMapping("/deletePerson")
    public void deletePerson(@RequestParam("personId") int personId) {
        personService.deleteById(personId);
    }

    @PostMapping("/showFormForPersonUpdate")
    public String showFormForPersonUpdate(@RequestParam("personId") int personId, Model theModel) {
        theModel.addAttribute(personService.findById(personId));
        return "personForm";
    }

    @PostMapping("/savePerson")
    public String savePerson(){
        return "redirect:/person";
    }

}
