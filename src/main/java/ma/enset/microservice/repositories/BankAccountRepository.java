package ma.enset.microservice.repositories;

import ma.enset.microservice.entities.BankAccount;
import org.springframework.boot.SpringApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {

}
