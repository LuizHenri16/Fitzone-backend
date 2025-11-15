package com.fitzone.FITZONE.Repository;

import com.fitzone.FITZONE.Models.Finance.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    @Override
    Page<Expense> findAll(Pageable pageable);

    @Query("SELECT SUM(e.value) FROM Expense e WHERE e.date >= :startDate")
    Double sumExpensesInLast30Days(@Param("startDate") LocalDate startDate);

}
