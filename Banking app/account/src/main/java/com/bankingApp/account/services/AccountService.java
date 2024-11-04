package com.bankingApp.account.services;

import com.bankingApp.account.dto.AccountDto;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto updateAccount(Integer accountID, AccountDto accountDto);
    void deleteAccount(Integer accountId);
    AccountDto getAccount(Integer accountId);
    List<AccountDto> getAccounts();
}
