package com.banck.accountmovements.aplication.impl;

import com.banck.accountmovements.domain.AccountType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.banck.accountmovements.aplication.AccountTypeOperations;
import com.banck.accountmovements.aplication.model.AccountTypeRepository;

/**
 *
 * @author jonavcar
 */
@Service
@RequiredArgsConstructor
public class AccountTypeOperationsImpl implements AccountTypeOperations {

    private final AccountTypeRepository repositoryCustomerType;

    @Override
    public Flux<AccountType> list() {
        return repositoryCustomerType.listAll();
    }

    @Override
    public Mono<AccountType> get(String dniRuc) {
        return repositoryCustomerType.get(dniRuc);
    }

    @Override
    public Mono<AccountType> create(AccountType c) {
        return repositoryCustomerType.create(c);
    }

    @Override
    public Mono<AccountType> update(String dniRuc, AccountType c) {
        return repositoryCustomerType.update(dniRuc, c);
    }

    @Override
    public void delete(String dniRuc) {
        repositoryCustomerType.delete(dniRuc);
    }

}
