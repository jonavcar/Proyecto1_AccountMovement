package com.banck.accountmovements.aplication;

import com.banck.accountmovements.domain.Customer;
import com.banck.accountmovements.domain.AccountType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author jonavcar
 */
public interface AccountTypeOperations {

    public Flux<AccountType> list();

    public Mono<AccountType> get(String id);

    public Mono<AccountType> create(AccountType c);

    public Mono<AccountType> update(String id, AccountType c);

    public void delete(String id);

}
