package ma.enset.microservice.web;

import ma.enset.microservice.entities.BankAccount;
import ma.enset.microservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@RestController
public class AccountRestController {


    private BankAccountRepository bankAccountRepository;

    public AccountRestController(BankAccountRepository bankAccountRepository){
        this.bankAccountRepository=bankAccountRepository;
    }
    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }
    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found ",id)));
    }

    @PostMapping("/bankAccounts")
    public BankAccount save(@RequestBody BankAccount bankAccount){
        return bankAccountRepository.save(bankAccount);
    }
    @PutMapping("/bankAccounts{id}")
    public BankAccount update(@PathVariable String id,@RequestBody BankAccount bankAccount){
        BankAccount account=bankAccountRepository.findById(id).orElseThrow();
        account.setBalance(bankAccount.getBalance());
        account.setCreatedAt(new Date());
        account.setType(bankAccount.getType());
        account.setCurrency(bankAccount.getCurrency());
        return bankAccountRepository.save(bankAccount);
    }
}
