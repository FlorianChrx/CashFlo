package fr.florianchrx.tradingAPI.controllers;

import fr.florianchrx.tradingAPI.model.Account;
import fr.florianchrx.tradingAPI.repositories.AccountRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/account")
public class AccountController {

    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * Use for get all the accounts
     *
     * @return an iterable of account
     */
    public Iterable<Account> getAll() {
        return accountRepository.findAll();
    }
}
