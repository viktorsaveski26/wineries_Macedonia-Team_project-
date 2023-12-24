package com.example.dizajn.veb;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/loginout")
public class LoginoutController {


    @GetMapping
    public String odjava(HttpServletRequest req)
    {
        req.getSession().invalidate();
        return "Login";
    }
}
