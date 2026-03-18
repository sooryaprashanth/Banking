package com.practise.banking.Repository;

import com.practise.banking.DTO.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
