package com.banck.accountmovements.infraestructure.rest;

import com.banck.accountmovements.domain.AccountType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.banck.accountmovements.aplication.AccountTypeOperations;

/**
 *
 * @author jonavcar
 */
@RestController
@RequestMapping("/customerType")
@RequiredArgsConstructor
public class AccountTypeController {

    private final AccountTypeOperations operations;

    @GetMapping
    public Flux<AccountType> listAll() {
        return operations.list();
    }

    @GetMapping("/{id}")
    public Mono<AccountType> get(@PathVariable("id") String id) {
        return operations.get(id);
    }

    @PostMapping
    public Mono<AccountType> create(@RequestBody AccountType c) {
        return operations.create(c);
    }

    @PutMapping("/{id}")
    public Mono<AccountType> update(@PathVariable("id") String id, @RequestBody AccountType c) {
        return operations.update(id, c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        operations.delete(id);
    }
}
