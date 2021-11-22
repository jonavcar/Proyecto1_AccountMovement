package com.banck.accountmovements.aplication.impl;

import com.banck.accountmovements.domain.Movement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.concurrent.atomic.AtomicReference;
import com.banck.accountmovements.aplication.MovementOperations;
import com.banck.accountmovements.aplication.model.MovementRepository;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonavcar
 */
@Service
@RequiredArgsConstructor
public class MovementOperationsImpl implements MovementOperations {

    private final MovementRepository movementRepository;

    @Override
    public Flux<Movement> list() {
        return movementRepository.list();
    }

    @Override
    public Mono<Movement> get(String movement) {
        return movementRepository.get(movement);
    }

    @Override
    public Mono<Movement> create(Movement movement) {
        AtomicReference<Mono<Movement>> atAccount = new AtomicReference<>();
        Flux<Movement> lstMovements = movementRepository.listByAccount(movement.getAccount());

        /*if (AccountType.SAVINGS_ACCOUNT.equals(movement.getAccountType())) {

            lstMovements.filter(act -> act.getMovementType().equals(movement.getMovementType()))
                    .count()
                    .subscribe(count -> {
                        if (count == 0) {
                            atAccount.set(movementRepository.create(movement));
                        } else {
                            atAccount.set(Mono.empty());
                        }
                    });
        } else if (AccountType.FIXED_TERM_ACCOUNT.equals(movement.getAccountType())) {

            lstMovements.filter(act -> act.getAccountType().equals(movement.getAccountType()))
                    .count()
                    .subscribe(count -> {
                        if (count == 0) {
                            atAccount.set(movementRepository.create(movement));
                        } else {
                            atAccount.set(Mono.empty());
                        }
                    });
        } else {
            atAccount.set(movementRepository.create(movement));
        }*/
        atAccount.set(movementRepository.create(movement));
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
            Logger.getLogger(MovementOperationsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return atAccount.get();
    }

    @Override
    public Mono<Movement> update(String movement, Movement c) {
        return movementRepository.update(movement, c);
    }

    @Override
    public void delete(String movement) {
        movementRepository.delete(movement);
    }

    @Override
    public Flux<Movement> listByCustomer(String customer) {
        return movementRepository.listByCustomer(customer);
    }

    @Override
    public Flux<Movement> listByCustomerAndAccount(String customer, String account) {
        return movementRepository.listByCustomerAndAccount(customer, account);
    }

    @Override
    public Flux<Movement> listByCustomerAndAccountAndAccountType(String customer, String account, String accountType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Flux<Movement> listByAccount(String movement) {
        return movementRepository.listByAccount(movement);
    }

}
