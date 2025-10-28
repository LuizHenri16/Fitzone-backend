package com.fitzone.FITZONE.Repository;

import com.fitzone.FITZONE.Models.Finance.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    @Override
    Page<Expense> findAll(Pageable pageable);
}
