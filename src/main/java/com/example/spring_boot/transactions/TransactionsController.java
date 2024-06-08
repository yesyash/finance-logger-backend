package com.example.spring_boot.transactions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {

    private final TransactionRepository repository;

    public TransactionsController(TransactionRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Transaction> all(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction createTransaction (@RequestBody Transaction transaction) {
        return repository.save(transaction);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTransaction(@PathVariable Long id){
        repository.deleteById(id);
    }
}
