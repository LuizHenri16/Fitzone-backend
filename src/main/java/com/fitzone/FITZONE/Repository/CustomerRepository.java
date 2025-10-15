package com.fitzone.FITZONE.Repository;

import com.fitzone.FITZONE.Models.Customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Override
    Page<Customer> findAll(Pageable pageable);
}
