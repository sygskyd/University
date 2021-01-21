package com.dmitry.university.controller;


import com.dmitry.university.model.IdentityCard.MilitaryCard;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dmitry.university.service.MilitaryCardServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/id-card")
public class IdentityCardController {
    private MilitaryCardServiceImpl militaryCardService;

    public IdentityCardController(MilitaryCardServiceImpl militaryCardService) {
        this.militaryCardService = militaryCardService;
    }

    @GetMapping("/military-cards")
    public String getMilitaryCards(Model theModel) {
        List <MilitaryCard> militaryCards = militaryCardService.findAll();
        theModel.addAttribute("militaryCards", militaryCards );
        return "/militarycards/militaryCardList";
    }

    @GetMapping("/showFormForMilAdd")
    public String showAddMilCardForm (Model theModel){
        MilitaryCard militaryCard = new MilitaryCard();
        theModel.addAttribute("militaryCard", militaryCard);
        return "/militarycards/milCardForm";
    }

    @PostMapping("/saveMilCard")
    public String saveMilCard (@ModelAttribute("employee") MilitaryCard militaryCard) {
        militaryCardService.save(militaryCard);
        return "redirect:/id-card/military-cards";
    }
}
