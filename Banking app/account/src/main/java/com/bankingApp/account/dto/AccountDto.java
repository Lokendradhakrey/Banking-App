package com.bankingApp.account.dto;

import com.bankingApp.account.entities.AccountType;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private Integer accountId;
    @Column(name = "account_holder_name")
    @NotNull(message = "Account holder name is required")
    private String accountHolderName;
    @Column(name = "account_type")
    @NotNull(message = "Account type is required")
    private AccountType accountType;
    @Column(name = "balance")
    @NotNull(message = "Balance is required")
    private BigDecimal balance;
    @Column(name = "account_no")
    private BigInteger accountNo;
    private LocalDateTime createdOn;
}
