package com.nsk.digital.nskdigibankaccount.repos;

import com.nsk.digital.nskdigibankaccount.entites.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {
    Optional<Accounts> findByCustomerId(Long customerId);

}
