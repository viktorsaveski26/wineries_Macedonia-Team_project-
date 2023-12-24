package com.example.dizajn.veb;
import com.example.dizajn.Exception.NoName;
import com.example.dizajn.service.Userservice;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    private final Userservice userservice;

    public RegistrationController(Userservice userservice) {
        this.userservice = userservice;
    }

    @GetMapping("/registration")
    public String registrationuser()
    {
        return "Registration";
    }
    @PostMapping("/registration")
    public String registrationdata(@RequestParam String name,
                                   @RequestParam String email,
                                   @RequestParam String surname,
                                   @RequestParam String password,
                                   @RequestParam String location,
                                   Model model)
    {
        try {
            userservice.registration(name, surname, email, password, location);
        }
        catch (NoName ex)
        {
            model.addAttribute("haserror", true);
            model.addAttribute("error", ex.getMessage());
            return "Registration";
        }
        return "redirect:/login";
    }

}
