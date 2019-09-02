package ecom.controller.admin.login;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = {"/",""})
public class LoginController 
{
    @GetMapping("/admin")
    public String getLoginInfo(Model model)
    {
        return "admin/login/login";
    }
    
    @GetMapping("/home")
    public String getPublicHomePage(Model model, HttpServletRequest request) 
    {
        return "index";
    }
    
    @PostMapping("/homeAdmin")
    public String validateLoginInfo(Model model, HttpServletRequest request,
            @RequestParam("email") String email,
            @RequestParam("password") String password) 
    {
        return "admin/home/home";
    }
    
    @GetMapping("/homeAdmin")
    public String getHomePageInfo(Model model, HttpServletRequest request) 
    {
        return "admin/home/home";
    }
}
