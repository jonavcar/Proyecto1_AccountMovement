package com.banck.accountmovements.aplication.model;

import com.banck.accountmovements.domain.AccountType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author jonavcar
 */
public interface AccountTypeRepository {

    public Mono<AccountType> get(String id);

    public Flux<AccountType> listAll();

    public Mono<AccountType> create(AccountType c);

    public Mono<AccountType> update(String id, AccountType c);

    public void delete(String id);
}
