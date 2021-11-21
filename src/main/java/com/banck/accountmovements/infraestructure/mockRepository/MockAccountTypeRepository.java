package com.banck.accountmovements.infraestructure.mockRepository;

import com.banck.accountmovements.domain.AccountType;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.banck.accountmovements.aplication.model.AccountTypeRepository;

/**
 *
 * @author jonavcar
 */
@Component
public class MockAccountTypeRepository implements AccountTypeRepository {

    @Override
    public Mono<AccountType> get(String dniRuc) {
        AccountType c = new AccountType();
        c.setCodigo("34984545");
        c.setNombre("CTP");
        c.setDescripcion("Empresa sac.");
        return Mono.just(c);
    }

    @Override
    public Flux<AccountType> listAll() {
        List<AccountType> lc = new ArrayList<>();
        AccountType c = new AccountType();
        c.setCodigo("34984545");
        c.setNombre("CTP");
        c.setDescripcion("Empresa sac.");
        lc.add(c);
        return Flux.fromIterable(lc);
    }

    @Override
    public Mono<AccountType> create(AccountType c) {
        return Mono.just(c);
    }

    @Override
    public Mono<AccountType> update(String dniRuc, AccountType c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String dniRuc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
