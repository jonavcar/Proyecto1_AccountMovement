package com.banck.accountmovements.infraestructure.repository;

import com.banck.accountmovements.infraestructure.model.dao.AccountTypeDao;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 *
 * @author jonavcar
 */
public interface IAccountTypeCrudRepository extends ReactiveCrudRepository<AccountTypeDao, String> {

}
