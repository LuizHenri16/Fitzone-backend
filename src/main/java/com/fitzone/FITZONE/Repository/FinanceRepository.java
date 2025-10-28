package com.fitzone.FITZONE.Repository;

import com.fitzone.FITZONE.DTO.PaymentDTO;
import com.fitzone.FITZONE.Models.Finance.License;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface FinanceRepository extends JpaRepository<License, Long> {
    @Query("Select l from License l where l.license = %:search%")
    Optional<License>searchByLicense(@Param("search") String license);

    @Query("SELECT p.lastPayment, c.name, l.price, c.email FROM Payment p JOIN p.customer c JOIN p.license l WHERE p.lastPayment >= :initialDate AND p.lastPayment <= :finallyDate")
    Page<PaymentDTO> findAllPayments(@Param("initialDate")LocalDate initialDate, @Param("finallyDate") LocalDate finallyDate, Pageable pageable);
}
