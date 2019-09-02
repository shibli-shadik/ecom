package ecom.controller.admin.setup;

import ecom.model.setup.Bank;
import ecom.service.setup.BankService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/banks")
public class BankController 
{
    @Autowired
    BankService bankService;
            
    @GetMapping(value = "")
    public String getAllBanks(Model model)
    {
        model.addAttribute("banks", bankService.getAllBanks());
        return "admin/bank/bankList";
    }
    
    @GetMapping("/create")
    public String createBank(Model model, HttpServletRequest request)
    {
        return "admin/bank/createBank";
    }
    
    @PostMapping(value = "/save")
    public ModelAndView saveBank(Bank bank, Model model)
    {
        model.addAttribute("message", bankService.saveBank(bank));
        model.addAttribute("banks", bankService.getAllBanks());
        
        return new ModelAndView("admin/bank/bankList");
    }
    
    @GetMapping("/{id}/edit")
    public String editBank(@PathVariable long id, Model model)
    {
        model.addAttribute("bank", bankService.getBank(id));
        return "admin/bank/editBank";
    }
    
    @PostMapping(value = "/update")
    public ModelAndView updateBank(Bank bank, Model model)
    {
        model.addAttribute("message", bankService.updateBank(bank));
        model.addAttribute("banks", bankService.getAllBanks());
        
        return new ModelAndView("admin/bank/bankList");
    }
    
    @GetMapping("/{id}/delete")
    public ModelAndView deleteBank(@PathVariable long id, Model model)
    {
        model.addAttribute("message", bankService.deleteBank(id));
        model.addAttribute("banks", bankService.getAllBanks());
        return new ModelAndView("admin/bank/bankList");
    }
}
