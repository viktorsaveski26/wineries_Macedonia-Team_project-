package com.example.dizajn.veb;

import com.example.dizajn.Exception.Nofound;
import com.example.dizajn.model.Userd;
import com.example.dizajn.service.Userservice;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    public final Userservice userService;

    public LoginController(Userservice userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpServletRequest req,
                        Model model) {
        Userd u = null;
        try {
            u = this.userService.login(email, password);
        } catch (Nofound ex) {
            model.addAttribute("haserrors", true);
            model.addAttribute("error", ex.getMessage());
            return "login";
        }
        req.getSession().setAttribute("user", u);
        return "redirect:/profil";
    }
}
