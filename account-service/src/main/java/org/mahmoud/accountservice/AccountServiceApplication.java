package org.mahmoud.accountservice;

import org.mahmoud.accountservice.entities.BankAccount;
import org.mahmoud.accountservice.enums.AccountType;
import org.mahmoud.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository){
        return args -> {
            bankAccountRepository.save(BankAccount.builder()
                    .id(UUID.randomUUID().toString())
                    .balance(44444.4)
                    .type(AccountType.CURRENT_ACCOUNT)
                    .createdAt(LocalDate.now())
                    .currency("USD")
                    .customerId(Long.valueOf(1))
                    .build());
            bankAccountRepository.save(BankAccount.builder()
                    .id(UUID.randomUUID().toString())
                    .balance(33333.4)
                    .type(AccountType.CURRENT_ACCOUNT)
                    .createdAt(LocalDate.now())
                    .currency("MAD")
                    .customerId(Long.valueOf(2))
                    .build());
        };
    }

}
