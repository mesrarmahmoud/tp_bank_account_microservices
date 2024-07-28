package org.mahmoud.accountservice.web;

import org.mahmoud.accountservice.clients.CustumerRestClient;
import org.mahmoud.accountservice.entities.BankAccount;
import org.mahmoud.accountservice.model.Customer;
import org.mahmoud.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountResetController {
    private BankAccountRepository bankAccountRepository;
    private CustumerRestClient custumerRestClient;

    public AccountResetController(BankAccountRepository bankAccountRepository, CustumerRestClient custumerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.custumerRestClient = custumerRestClient;

    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccountsList() {
        return bankAccountRepository.findAll();
    }
    @GetMapping("/bankAccounts/{id}")
    public BankAccount accountById( @PathVariable String id){
        BankAccount bankAccount = bankAccountRepository.findById(id).get();
        System.out.println(bankAccount.getCustomerId());
        Customer customer = custumerRestClient.findCustomerById(Long.valueOf(1));
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
