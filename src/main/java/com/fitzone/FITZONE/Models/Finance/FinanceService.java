package com.fitzone.FITZONE.Models.Finance;

import com.fitzone.FITZONE.DTO.ExpenseDTO;
import com.fitzone.FITZONE.DTO.PaymentDTO;
import com.fitzone.FITZONE.Models.Customer.Customer;
import com.fitzone.FITZONE.Models.Customer.CustomerService;
import com.fitzone.FITZONE.Repository.CustomerRepository;
import com.fitzone.FITZONE.Repository.ExpenseRepository;
import com.fitzone.FITZONE.Repository.FinanceRepository;
import com.fitzone.FITZONE.Repository.PaymentRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FinanceService {

    private final FinanceRepository financeRespository;
    private final ExpenseRepository expenseRepository;
    private final PaymentRepository paymentRepository;
    private final CustomerRepository customerRepository;

    public FinanceService(FinanceRepository financeRespository, ExpenseRepository expenseRepository, PaymentRepository paymentRepository, CustomerRepository customerRepository) {
        this.financeRespository = financeRespository;
        this.expenseRepository = expenseRepository;
        this.paymentRepository = paymentRepository;
        this.customerRepository = customerRepository;
    }

    public Payment savePayment(Long customerId) {
        Customer customer = customerRepository.getReferenceById(customerId);
        Payment payment = new Payment(customer.getLicense(), LocalDate.now(), customer);
        return paymentRepository.save(payment);
    }

    public Page<Payment> getPayments(Pageable pageable) {
        Page<Payment> payments = financeRespository.findAllPayments(LocalDate.now().minusDays(30), LocalDate.now(), pageable);

        return payments.map(payment -> {
            return new PaymentDTO(
                    payment,
                    payment.getCustomer()
            ).getPayment();
        });
    }

    public Double buscarTotalDespesasUltimos30Dias() {
        LocalDate trintaDias = LocalDate.now().minusDays(30);
        Double total = expenseRepository.sumExpensesInLast30Days(trintaDias);

        return total != null ? total : 0.0;
    }

    public Double buscarTotalPagamentosUltimos30Dias() {
        LocalDate trintaDias = LocalDate.now().minusDays(30);
        Double total = paymentRepository.sumLicenseValuesForPaymentsInLast30Days(trintaDias);

        return total != null ? total : 0.0;
    }

    public Payment buscarPagamentoPorCliente(Long clienteId) {
        return financeRespository.findLatestPaymentByClienteId(clienteId);
    }

    public Optional<License> getLicenseByName(String license) {
        return financeRespository.searchByLicense(license);
    }

    public Expense saveExpense(ExpenseDTO expenseDTO) {
        Expense expense = new Expense(
                expenseDTO.getDescription(),
                expenseDTO.getValue(),
                expenseDTO.getDate()
        );
        return expenseRepository.save(expense);
    }

    public Page<Expense> getExpenses(Pageable pageable) {
        return expenseRepository.findAll(pageable);
    }
}
