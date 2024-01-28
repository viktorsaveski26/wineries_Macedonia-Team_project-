package com.example.dizajn.veb;

import com.example.dizajn.service.Userservice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfilController {

    private final Userservice userservice;

    public ProfilController(Userservice userservice) {
        this.userservice = userservice;
    }

    @GetMapping("/profil")
    public String Profil(Model model, @RequestParam(required = false) Long id) {
        if (id != null) {
            model.addAttribute("poeni", userservice.soberipoeni(id));
        }
        return "Profil";
    }

    @PostMapping("/profil")
    public String Profili() {
        return "Profil";
    }
}
