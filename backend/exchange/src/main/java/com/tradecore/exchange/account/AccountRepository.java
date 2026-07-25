package com.tradecore.exchange.account;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,UUID>{

    Optional<Account> findByEmail(String email);
 
    boolean existsByEmail(String email);

}
