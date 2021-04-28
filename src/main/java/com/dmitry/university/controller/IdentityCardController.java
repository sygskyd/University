package com.dmitry.university.controller;


import com.dmitry.university.model.IdentityCard.BaseIdentityEntity;
import com.dmitry.university.model.person.Person;
import com.dmitry.university.service.IdentityCardService;
import com.dmitry.university.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.dmitry.university.service.IdentityCardServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/id-card")
public class IdentityCardController {

    @Autowired
    private PersonService personService;

    @Autowired
    private IdentityCardService identityCardService;

    public IdentityCardController(PersonService personService, IdentityCardService identityCardService) {
        this.personService = personService;
        this.identityCardService = identityCardService;
    }


    @GetMapping("/identity-cards")
    public String getIdentityCards(HttpServletRequest request, Model theModel) {

        int page = 0; //default page number
        int size = 5; // default page size

        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
            page = Integer.parseInt(request.getParameter("page")) - 1;
        }

        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
            size = Integer.parseInt(request.getParameter("size"));
        }

        Page<BaseIdentityEntity> identityCards = identityCardService.findAll(page, size);
        theModel.addAttribute("identityCards", identityCards );
        return "/identitycards/identityCardList";
    }

    @GetMapping("/showFormForCardAdd")
    public String showAddIdCardForm (Model theModel){
        List<Person> personList = personService.findAll();
        List<Person> freePersonList = personList.stream()
                .filter(person -> person.getBaseIdentityEntity() == null)
                .collect(Collectors.toList());
        theModel.addAttribute("freePersonList", freePersonList);
        BaseIdentityEntity identityCard = new BaseIdentityEntity();
        theModel.addAttribute("identityCard", identityCard);
        return "/identitycards/idCardForm";
    }

    @PostMapping("/saveIdentityCard")
    public String saveIdCard (@ModelAttribute("identityCard") @Valid BaseIdentityEntity identityCard, BindingResult result) {
        if (result.hasErrors()) {

            return "/identitycards/idCardForm";
        }
        identityCardService.save(identityCard);
        return "redirect:/id-card/identity-cards";
    }

    @PostMapping("/showFormForCardUpdate")
    public String showUpdateIdCardForm (@RequestParam("cardId")  int cardId, Model theModel) {
        BaseIdentityEntity identityCard = identityCardService.findById(cardId);
        theModel.addAttribute("identityCard", identityCard);
        List<Person> personList = personService.findAll();
        List<Person> freePersonList = personList.stream()
                .filter(person -> person.getBaseIdentityEntity() == null)
                .collect(Collectors.toList());
        freePersonList.add(identityCard.getPerson());
        theModel.addAttribute("freePersonList", freePersonList);
        return "/identitycards/idCardEditForm";
    }

    @PostMapping("/deleteCard")
    public String deleteCard (@RequestParam("cardId") int cardId) {
        identityCardService.deleteById(cardId);
        return "redirect:/id-card/identity-cards";
    }
}
