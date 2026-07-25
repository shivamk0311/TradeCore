package com.tradecore.exchange.account;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tradecore.exchange.common.exceptions.DuplicateEmailException;


@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    private AccountResponse mapper(Account account){
        AccountResponse accountResponse = new AccountResponse(account.getId(), account.getEmail(), account.getDisplayName(), account.getStatus(), account.getCreatedAt(), account.getUpdatedAt());
        return accountResponse;
    }


    @Transactional
    public AccountResponse createAccount(CreateAccountRequest accountRequest){

        String email = accountRequest.email().trim().toLowerCase();
        String displayName = accountRequest.displayName().trim();
        
        if(accountRepository.existsByEmail(email)){
            throw new DuplicateEmailException("Email already exists.");
        }

        Account account = new Account(email, displayName );
        Account savedAccount = accountRepository.save(account);
        
        
        return mapper(savedAccount);
    }


}
