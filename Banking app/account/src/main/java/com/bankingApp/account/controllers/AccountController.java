package com.bankingApp.account.controllers;

import com.bankingApp.account.dto.AccountDto;
import com.bankingApp.account.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts/v1")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    // Add your endpoints here
    @PostMapping("/create")
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @PutMapping("/update/{accountId}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable Integer accountId ,@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.updateAccount(accountId,accountDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{accountId}")
    public ResponseEntity<?> deleteAccount(@PathVariable Integer accountId) {
        accountService.deleteAccount(accountId);
        return ResponseEntity.ok("Account deleted successfully");
    }
    @GetMapping("/get/{accountId}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable Integer accountId) {
        return new ResponseEntity<>(accountService.getAccount(accountId), HttpStatus.OK);
    }

    @GetMapping("/getAllAccounts")
    public ResponseEntity<?> getAllAccounts() {
        return new ResponseEntity<>(accountService.getAccounts(), HttpStatus.OK);
    }
}
