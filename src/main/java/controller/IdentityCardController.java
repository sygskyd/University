package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("identitycard")
public class IdentityCardController {

    @GetMapping("/MilitaryCard")
    public String getMilitaryCard() {
        return "militaryCard";
    }
}
