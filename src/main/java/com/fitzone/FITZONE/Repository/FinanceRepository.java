package com.fitzone.FITZONE.Repository;

import com.fitzone.FITZONE.DTO.PaymentDTO;
import com.fitzone.FITZONE.Models.Finance.License;
import com.fitzone.FITZONE.Models.Finance.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface FinanceRepository extends JpaRepository<License, Long> {
    @Query("Select l from License l where l.license = %:search%")
    Optional<License>searchByLicense(@Param("search") String license);

    @Query("SELECT p FROM Payment p " +
            "JOIN FETCH p.customer c " +
            "WHERE p.lastPayment >= :initialDate AND p.lastPayment <= :finallyDate")
    Page<Payment> findAllPayments(@Param("initialDate")LocalDate initialDate, @Param("finallyDate") LocalDate finallyDate, Pageable pageable);

    @Query("SELECT p FROM Payment p JOIN FETCH p.customer c WHERE c.id = :clienteId AND p.id = (SELECT MAX(p2.id) FROM Payment p2 WHERE p2.customer.id = :clienteId)")
    Payment findLatestPaymentByClienteId(@Param("clienteId") Long clienteId);


}
