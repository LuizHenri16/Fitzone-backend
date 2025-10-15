package com.fitzone.FITZONE.Models.Finance;

import com.fitzone.FITZONE.Repository.FinanceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FinanceService {

    private final FinanceRepository financeRespository;

    public FinanceService(FinanceRepository financeRespository) {
        this.financeRespository = financeRespository;
    }

    public Optional<License> getLicenseByName(String license) {
        return financeRespository.searchByLicense(license);
    }
 }
