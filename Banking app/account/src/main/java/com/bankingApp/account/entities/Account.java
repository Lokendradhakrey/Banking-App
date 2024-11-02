package com.bankingApp.account.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer accountId;
    private String accountHolderName;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private BigDecimal balance;
    private BigInteger accountNo;
    private LocalDateTime createdOn;
}
