package fr.florianchrx.controllers;

import fr.florianchrx.model.SymbolsEntity;
import fr.florianchrx.repositories.SymbolsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/symbol")
public class SymbolsController {

    @Autowired
    private SymbolsRepository symbolsRepository;

    @GetMapping(path = "/all")
    public Iterable<SymbolsEntity> GetAllSymbols() {
        System.out.println(symbolsRepository.findAll());
        return symbolsRepository.findAll();
    }

}
