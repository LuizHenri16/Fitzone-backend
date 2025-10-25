package com.fitzone.FITZONE.Repository;

import com.fitzone.FITZONE.Models.Finance.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FinanceRepository extends JpaRepository<License, Long> {

    @Query("Select l from License l where l.license = %:search%")
    Optional<License>searchByLicense(@Param("search") String license);
}
