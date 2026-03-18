package com.practise.banking.Repository;

import com.practise.banking.DTO.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
