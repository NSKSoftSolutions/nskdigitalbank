package com.nsk.digital.nskdigibank.accountservices.repos;

import com.nsk.digital.nskdigibank.accountservices.entites.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {
    Optional<Accounts> findByCustomerId(Long customerId);

}
