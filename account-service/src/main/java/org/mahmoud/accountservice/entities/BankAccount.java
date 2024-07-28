package org.mahmoud.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.mahmoud.accountservice.enums.AccountType;
import org.mahmoud.accountservice.model.Customer;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccount {
    @Id
    private String id;
    private Double balance;
    private String currency;
    private LocalDate createdAt;
    @Enumerated(EnumType.STRING)
    private AccountType type;

    @Transient //ignorer
    private Customer customer;

    private Long customerId;

}
