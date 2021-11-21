package com.banck.accountmovements.spring.config;

import com.banck.accountmovements.aplication.model.CustomerRepository;
import com.banck.accountmovements.infraestructure.repository.MovementCrudRepository;
import com.banck.accountmovements.infraestructure.repository.CustomerCrudRepository;
import com.banck.accountmovements.infraestructure.repository.AccountTypeCrudRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.banck.accountmovements.aplication.model.MovementRepository;
import com.banck.accountmovements.aplication.model.AccountTypeRepository;

/**
 *
 * @author jonavcar
 */
@Configuration
public class SpringConfiguration {

    @Bean
    public CustomerRepository repository() {
        return new CustomerCrudRepository();
    }

    @Bean
    public AccountTypeRepository repositoryCustomerType() {
        return new AccountTypeCrudRepository();
    }
    
    @Bean
    public MovementRepository movementRepository() {
        return new MovementCrudRepository();
    }
}
