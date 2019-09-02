package ecom.service.setup;

import ecom.model.setup.Bank;
import java.util.List;

public interface BankService 
{
    List<Bank> getAllBanks();
    String saveBank(Bank bank);
    Bank getBank(long id);
    String updateBank(Bank bank);
    String deleteBank(long id);
}
