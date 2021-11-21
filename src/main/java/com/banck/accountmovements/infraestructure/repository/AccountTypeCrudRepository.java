package com.banck.accountmovements.infraestructure.repository;

import com.banck.accountmovements.domain.AccountType;
import com.banck.accountmovements.infraestructure.model.dao.CustomerDao;
import com.banck.accountmovements.infraestructure.model.dao.AccountTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.banck.accountmovements.aplication.model.AccountTypeRepository;

/**
 *
 * @author jonavcar
 */
@Component
public class AccountTypeCrudRepository implements AccountTypeRepository {

    @Autowired
    IAccountTypeCrudRepository repositoryCustomerType;

    @Override
    public Mono<AccountType> get(String id) {
        return repositoryCustomerType.findById(id).map(this::CustomerDaoToCustomer);
    }

    public AccountType CustomerDaoToCustomer(AccountTypeDao cd) {
        AccountType customer = new AccountType();
        customer.setCodigo(cd.getCodigo());
        customer.setNombre(cd.getNombre());
        customer.setDescripcion(cd.getDescripcion());
        return customer;
    }

    @Override
    public Flux<AccountType> listAll() {
        return repositoryCustomerType.findAll().map(this::CustomerDaoToCustomer);
    }

    @Override
    public Mono<AccountType> create(AccountType c) {
        return repositoryCustomerType.save(CustomerToCustomerDao(c)).map(this::CustomerDaoToCustomer);
    }

    @Override
    public Mono<AccountType> update(String id, AccountType c) {
        c.setCodigo(id);
        return repositoryCustomerType.save(CustomerToCustomerDao(c)).map(this::CustomerDaoToCustomer);
    }

    @Override
    public void delete(String id) {
        repositoryCustomerType.deleteById(id);
    }

    public AccountTypeDao CustomerToCustomerDao(AccountType c) {
        AccountTypeDao typeDao = new AccountTypeDao();
        typeDao.setCodigo(c.getCodigo());
        typeDao.setNombre(c.getNombre());
        typeDao.setDescripcion(c.getDescripcion());
        return typeDao;
    }

}
