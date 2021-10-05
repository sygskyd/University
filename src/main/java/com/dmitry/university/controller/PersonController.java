package com.dmitry.university.controller;


import com.dmitry.university.model.Community.StudyGroup;
import com.dmitry.university.model.person.Person;
import com.dmitry.university.model.table2table.Person2Group;
import com.dmitry.university.service.IPerson2GroupService;
import com.dmitry.university.service.IPersonService;
import com.dmitry.university.service.IStudyGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private IPerson2GroupService person2GroupService;

    @Autowired
    private IPersonService personService;

    @Autowired
    private IStudyGroupService studyGroupService;

    public PersonController(IPersonService personService, IStudyGroupService studyGroupService, IPerson2GroupService person2GroupService) {
        this.personService = personService;
        this.studyGroupService = studyGroupService;
        this.person2GroupService = person2GroupService;
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
        return "person/person";
    }

    @PostMapping("/deletePerson")
    public String deletePerson(@RequestParam("personId") int personId) {
        personService.deleteById(personId);
        return "redirect:/person";
    }

    @GetMapping("/showFormForPersonAdd")
    public String showAddIdCardForm (Model theModel){
        Person person = new Person();
        theModel.addAttribute("person", person);
        List<StudyGroup> studyGroupList= studyGroupService.findAll();
        theModel.addAttribute("studyGroupList", studyGroupList);
        return "person/personForm";
    }

    @PostMapping("/showFormForPersonUpdate")
    public String showFormForPersonUpdate(@RequestParam("personId") int personId, Model theModel) {
        Person person = personService.findById(personId);
        String personsGroupName = person.getStudyGroup().getGroupName();
        theModel.addAttribute( "person", person);
        theModel.addAttribute( "personsGroupName", personsGroupName);
        List<StudyGroup> studyGroupList= studyGroupService.findAll();
        theModel.addAttribute("studyGroupList", studyGroupList);
        return "person/personForm";
    }

    @PostMapping("/savePerson")
    public String savePerson(@ModelAttribute("person") @Valid Person person, BindingResult result){
        if (result.hasErrors()) {
            return "person/personForm";
        }
        personService.save(person);
        return "redirect:/person";
    }

}
