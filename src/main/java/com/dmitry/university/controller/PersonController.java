package com.dmitry.university.controller;


import com.dmitry.university.model.Community.StudyGroup;
import com.dmitry.university.model.person.Person;
import com.dmitry.university.service.PersonService;
import com.dmitry.university.service.PersonServiceImpl;
import com.dmitry.university.service.StudyGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServiceImpl personService;
    @Autowired
    private StudyGroupService studyGroupService;

    public PersonController(PersonServiceImpl personService, StudyGroupService studyGroupService) {
        this.personService = personService;
        this.studyGroupService = studyGroupService;
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
    public String deletePerson(@RequestParam("personId") int personId) {
        personService.deleteById(personId);
        return "redirect:/person";
    }

    @PostMapping("/showFormForPersonUpdate")
    public String showFormForPersonUpdate(@RequestParam("personId") int personId, Model theModel) {
        Person person = personService.findById(personId);
        String personsGroupName = person.getStudyGroup().getGroupName();
        theModel.addAttribute( "person", person);
        theModel.addAttribute( "personsGroupName", personsGroupName);
        List<StudyGroup> studyGroupList = studyGroupService.findAll();
        theModel.addAttribute( "studyGroupList", studyGroupList);
        return "personForm";
    }

    @PostMapping("/savePerson")
    public String savePerson(@ModelAttribute("person") @Valid Person person, BindingResult result){
        if (result.hasErrors()) {
            return "/person/personForm";
        }
        personService.save(person);
        return "redirect:/person";
    }

}
