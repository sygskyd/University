package com.dmitry.university.controller;


import com.dmitry.university.model.Community.StudyGroup;
import com.dmitry.university.service.StudyGroupService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/studyGroup")
public class StudyGroupController {

    StudyGroupService studyGroupService;

    public StudyGroupController(StudyGroupService studyGroupService) {
        this.studyGroupService = studyGroupService;
    }


    @GetMapping("")
    public String getAllGroups(Model model) {
        List<StudyGroup> studyGroupList = studyGroupService.findAll();
        model.addAttribute("studyGroupList", studyGroupList);
        return "/studyGroup/studyGroups";
    }

    @GetMapping("/addStudyGroup")
    public String showAddClientForm(Model model){
        model.addAttribute("studyGroup",new StudyGroup());
        return "/studyGroup/addStudyGroupView";
    }
//TODO search function
//    @GetMapping("/searchStudyGroup")
//    public String searchClient(@RequestParam("name") @Valid String name, Model model){
//        List<StudyGroup> studyGroupList=studyGroupService.findClientsByName(name);
//        model.addAttribute("studyGroupList", studyGroupList);
//        return "/studyGroup/studyGroups";
//    }

    @PostMapping("/addStudyGroup")
    public String saveClient(@ModelAttribute("client") @Valid StudyGroup client){
        studyGroupService.save(client);
        return "redirect:/studyGroup/studyGroups";
    }

    @GetMapping("/showFormForStudyGroupUpdate")
    public String getForPostEditClient(@RequestParam("id") @Valid int id, Model model){
        model.addAttribute("client",studyGroupService.findById(id));
        return "/studyGroup/editStudyGroupView";
    }


    @PostMapping("/showFormForStudyGroupUpdate")
    public String showFormForEditClient(@RequestParam("id") @Valid int id, Model model) {
        StudyGroup client = studyGroupService.findById(id);
        model.addAttribute("client", client);
        return "/studyGroup/editStudyGroupView";
    }

    @PostMapping("/deleteStudyGroup")
    public String deleteClient(@RequestParam("id") @Valid int id) {
        studyGroupService.deleteById(id);
        return "redirect:/studyGroup/studyGroups";
    }

}
