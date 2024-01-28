package com.example.dizajn.veb;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginoutController {

    @GetMapping("/loginout")
    public String odjava(HttpServletRequest req) {
        req.getSession().invalidate();
        return "login";
    }
}

