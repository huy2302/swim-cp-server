package com.example.swim_server.service;

import com.example.swim_server.entity.Account;
import com.example.swim_server.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public List<Account> getAllAccounts() {
        return repository.findAll();
    }

    public Account saveAccount(Account account) {
        return repository.save(account);
    }

    public Account updateBindStatus(UUID uuid, String bindStatus) {
        Account account = repository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        account.setBindStatus(bindStatus);
        return repository.save(account);
    }

    public void deleteAccount(UUID uuid) {
        repository.deleteById(uuid);
    }
}