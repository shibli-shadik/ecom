package ecom.service.setup.impl;

import ecom.model.setup.Bank;
import ecom.model.setup.repository.BankRepository;
import ecom.service.setup.BankService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService 
{
    @Autowired
    private BankRepository bankRepository;

    @Override
    public List<Bank> getAllBanks() 
    {
        return (List<Bank>) bankRepository.findAll();
    }

    @Override
    public String saveBank(Bank bank) 
    {
        String status = "";
        
        if(bankRepository.save(bank) != null)
        {
            status = "Saved";
        }
        else
        {
            status = "Error";
        }
                
        return status;
    }

    @Override
    public Bank getBank(long id) 
    {
        Optional<Bank> optBank = bankRepository.findById(id);
        
        return optBank.get();
    }
    
    @Override
    public String updateBank(Bank bank) 
    {
        String status = "";
        
        if(bankRepository.save(bank) != null)
        {
            status = "Updated";
        }
        else
        {
            status = "Error";
        }
                
        return status;
    }
    
    @Override
    public String deleteBank(long id) 
    {
        bankRepository.deleteById(id);
        
        return "Deleted";
    }
}
