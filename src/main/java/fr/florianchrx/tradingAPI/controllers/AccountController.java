package fr.florianchrx.tradingAPI.controllers;

import fr.florianchrx.tradingAPI.model.*;
import fr.florianchrx.tradingAPI.repositories.AccountRepository;
import fr.florianchrx.tradingAPI.repositories.TradesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller helps to manage trading accounts. A trading account is an actual
 * quantity of a symbol on an address in specific chain.
 *
 * @see Account
 */
@RestController
@RequestMapping(path = "/account")
public class AccountController {

    private final AccountRepository accountRepository;
    private final TradesRepository tradesRepository;

    public AccountController(AccountRepository accountRepository, TradesRepository tradesRepository) {
        this.accountRepository = accountRepository;
        this.tradesRepository = tradesRepository;
    }

    /**
     * Use for get all the accounts
     *
     * @return an iterable of account
     */
    @GetMapping("/")
    public Iterable<Account> getAll() {
        return accountRepository.findAll();
    }

    /**
     * Use for generate a trade list which permits to be coherent with actual amount of account
     *
     * @param id the id of the account to be refreshed
     * @return the list of trade added for refresh the account
     * @deprecated This method is actually not appropriate for this task.
     */
    @Deprecated
    @GetMapping("/id/{id}/refresh")
    public Response<Iterable<Trade>> refresh(@PathVariable long id) {
        Account account = accountRepository.findById(id).orElseThrow();
        Calculator calculator = new SimpleCalculator(tradesRepository.getBuysBySymbol(account.getSymbol()), tradesRepository.getSellsBySymbol(account.getSymbol()));
        Iterable<Trade> trades = new SimpleAccountManager(calculator).refresh(account);
        tradesRepository.saveAll(trades);
        return new DeprecatedResponse<>(trades);
    }

    /**
     * Use for generate a trade list which permits to be coherent with actual amount of all accounts for a symbol
     *
     * @param symbolId the symbol id to be refreshed
     * @return the list of trade added for refresh the symbol
     */
    @GetMapping("/symbol/{symbolId}/refresh")
    public Response<Iterable<Trade>> refreshSymbol(@PathVariable long symbolId) {
        Account account = accountRepository.findBySymbolId(symbolId);
        Calculator calculator = new SimpleCalculator(tradesRepository.getBuysBySymbol(account.getSymbol()), tradesRepository.getSellsBySymbol(account.getSymbol()));
        Iterable<Trade> trades = new SimpleAccountManager(calculator).refresh(account);
        tradesRepository.saveAll(trades);
        return new Response<>(trades);
    }

    /**
     * Use for call a refresh on all symbols
     *
     * @return All the list of trade which permit to be coherent with actual amounts of all symbols
     */
    @GetMapping("/refresh")
    public Response<Iterable<Iterable<Trade>>> refresh() {
        return new Response<>(null, false, "Not yet implemented");
    }
}
