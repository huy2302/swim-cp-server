package com.example.swim_server.controller;

import com.example.swim_server.entity.Account;
import com.example.swim_server.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/accounts")
@CrossOrigin(origins = "*")
public class AccountController {

    @Autowired
    private AccountService service;

    @GetMapping
    public List<Account> getAll() {
        return service.getAllAccounts();
    }

    @PostMapping
    public Account create(@RequestBody Account account) {
        return service.saveAccount(account);
    }

    @PatchMapping("/{uuid}/bind-status")
    public Account updateBind(@PathVariable UUID uuid, @RequestParam String status) {
        return service.updateBindStatus(uuid, status);
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable UUID uuid) {
        service.deleteAccount(uuid);
    }
}