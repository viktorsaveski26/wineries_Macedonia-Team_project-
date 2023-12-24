package com.example.dizajn.veb;
import com.example.dizajn.model.Vina;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import com.example.dizajn.repository.VinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MapController {
    @Autowired
    private VinaRepository vinaRepository;

    @GetMapping("/map")
    public String showMap(Model model) {
        List<Vina> vinaList = vinaRepository.findAll();
        model.addAttribute("vinaList", vinaList);
        return "mapa";
    }

}
