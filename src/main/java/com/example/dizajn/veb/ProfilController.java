package com.example.dizajn.veb;

import com.example.dizajn.service.Userservice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/profil")
public class ProfilController {

    public ProfilController(Userservice userservice) {
        this.userservice = userservice;
    }

    private final Userservice userservice;

    @GetMapping
    public String Profil(Model model, @RequestParam (required = false) Long id)
    {
        if(id!=null) {
            model.addAttribute("poeni", userservice.soberipoeni(id));
        }
        return "Profil";

    }

    @PostMapping
    public String Profili()
    {
        return "Profil";
    }

}

