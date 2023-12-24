package com.example.dizajn.veb;


import com.example.dizajn.model.Vina;
import com.example.dizajn.service.VinaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/pocetna")
public class VinaController {

    public VinaController(VinaService vinaService) {
        this.vinaService = vinaService;
    }

    public final VinaService vinaService;


    @GetMapping
    public String getvina(Model model)
    {
        List<Vina> vinaList = vinaService.sort();
        model.addAttribute("vinalist", vinaList);
        return "Pocetna";
    }
    @PostMapping
    public String pocetna(Model model)
    {
        List<Vina> vinaList = vinaService.listall();
        model.addAttribute("vinalist", vinaList);
        return "Pocetna";
    }
    @GetMapping("/addocena")
    public  String dodajocena(Model model)
    {
        model.addAttribute("vina", vinaService.listall());
        return "Addocena";
    }
    @PostMapping ("/ocena")
    public String daj(Model model, @RequestParam Long idkorisnik,
                                   @RequestParam Long vinarija)
    {
        return "Profil";
    }
}
