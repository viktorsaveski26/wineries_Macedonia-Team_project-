package com.example.dizajn.veb;

import com.example.dizajn.model.Vina;
import com.example.dizajn.repository.VinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Controller
public class VineyardController {

    @Autowired
    private VinaRepository vinaRepository;

    @GetMapping("/{name}.html")
    public ModelAndView showVineyardDetails(@PathVariable String name) {
        ModelAndView modelAndView = new ModelAndView(name + ".html");

        try {
            // Кодирање на името на винаријата за вклучување во URL
            String encodedName = URLEncoder.encode(name, StandardCharsets.UTF_8.toString());

            Optional<Vina> vinaOptional = vinaRepository.findByName(encodedName);
            if (vinaOptional.isPresent()) {
                Vina vina = vinaOptional.get();
                modelAndView.addObject("vineyard", vina);
            } else {
                modelAndView.setViewName("error-page");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            modelAndView.setViewName("error-page");
        }

        return modelAndView;
    }
}
