package com.bankingApp.account.services.impl;

import com.bankingApp.account.dto.AccountDto;
import com.bankingApp.account.entities.Account;
import com.bankingApp.account.repositories.AccountRepo;
import com.bankingApp.account.services.AccountService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Builder
public class AccountServiceImpl implements AccountService {

    private final AccountRepo accountRepository;
    private final ModelMapper modelMapper;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = modelMapper.map(accountDto, Account.class);
        account.setCreatedOn(LocalDateTime.now());
        account = accountRepository.save(account);
        return modelMapper.map(account, AccountDto.class);
    }

    @Override
    public AccountDto updateAccount(Integer accountId, AccountDto accountDto) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
        account.setAccountNo(accountDto.getAccountNo());
        account.setAccountHolderName(accountDto.getAccountHolderName());
        account.setAccountType(accountDto.getAccountType());
        account.setBalance(accountDto.getBalance());
        account.setCreatedOn(LocalDateTime.now());
        account = accountRepository.save(account);
        return modelMapper.map(account, AccountDto.class);
    }

    @Override
    public void deleteAccount(Integer accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
        accountRepository.delete(account);
    }

    @Override
    public AccountDto getAccount(Integer accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
        return modelMapper.map(account, AccountDto.class);
    }

    @Override
    public List<AccountDto> getAccounts() {
        return accountRepository.findAll().stream()
                .map(account -> modelMapper.map(account, AccountDto.class))
                .toList();
    }
}