package ecom.model.setup.repository;

import ecom.model.setup.Bank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends CrudRepository<Bank, Long> 
{
    
}
