package com.fitzone.FITZONE.Repository;

import com.fitzone.FITZONE.Models.Finance.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Override
    Page<Payment> findAll(Pageable pageable);

    @Query("SELECT SUM(p.license.price) FROM Payment p WHERE p.lastPayment >= :startDate")
    Double sumLicenseValuesForPaymentsInLast30Days(@Param("startDate") LocalDate startDate);
}
