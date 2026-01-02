package controller;

import entity.Admin;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.AdminService;

@Controller
@RequestMapping("/home")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("/register")
    public String loginAction(@ModelAttribute Admin admin){
        Admin dbAdmin = adminService.registerAdmin(admin);
        if(dbAdmin!=null){
            return "redirect:/home";
        }
        else
            return "register";
    }
    @PostMapping("/login")
    public String signInAction(@ModelAttribute Admin admin,HttpSession session){
        Admin dbAdmin = adminService.authenticateAdmin(admin);
        if(dbAdmin!=null){
            session.setAttribute("isLoggedIn",true);
            return "redirect:/dashboard";
        }
        else
            return "redirect:/home";
    }
}
