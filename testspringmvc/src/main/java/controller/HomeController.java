package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    // http://localhost:8080/testmvc/home ---> GET/POST/PUT/DELETE
    @GetMapping("/")
    public String getHomePage() {
        return "home";
    }

    @GetMapping("/create-account")
    public String getCreateAccount(){
        return "register";
    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }
}