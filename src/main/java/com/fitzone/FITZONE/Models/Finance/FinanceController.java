package com.fitzone.FITZONE.Models.Finance;

import com.fitzone.FITZONE.DTO.ExpenseDTO;
import com.fitzone.FITZONE.DTO.PaymentDTO;
import com.fitzone.FITZONE.DTO.PaymentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/finance")
public class FinanceController {

    private final FinanceService financeService;

    public FinanceController(FinanceService financeService) {
        this.financeService = financeService;
    }

    @PostMapping("/expense")
    public ResponseEntity<Expense> postExpense(@RequestBody ExpenseDTO expenseDTO) {
        Expense newExpense = financeService.saveExpense(expenseDTO);
        return new ResponseEntity<>(newExpense,HttpStatus.CREATED);
    }

    @GetMapping("/expense")
    public ResponseEntity<Page<Expense>> getExpenses(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        Page<Expense> expenses = financeService.getExpenses(pageable);

        if (expenses == null || expenses.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(expenses);
    }

    @GetMapping("expense/total")
    public ResponseEntity<?> getTotalExpense() {
        Double total = financeService.buscarTotalDespesasUltimos30Dias();

        Map<String, Object> response = new HashMap<>();

        if (total != 0.0) {
            response.put("status", "não encontrado");
            response.put("mensagem", "sem despesa");
            response.put("valor", total);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("status", "despesas cadastrados");
            response.put("mensagem", "despesas encontradas na base de dados");
            response.put("valor", total);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @PostMapping("/payment/{customerId}")
    public ResponseEntity<Payment> postPayment(@PathVariable Long customerId) {
        Payment payment = financeService.savePayment(customerId);
        return new ResponseEntity<>(payment, HttpStatus.CREATED);
    }


    @GetMapping("/payment")
    public ResponseEntity<Page<Payment>> getPayments(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        Page<Payment> payments = financeService.getPayments(pageable);

        if (payments == null || payments.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(payments);
    }


    @GetMapping("/payment/{id}")
    public ResponseEntity<PaymentResponse> getPayment(@PathVariable Long id) {
        Payment payment = financeService.buscarPagamentoPorCliente(id);

        PaymentResponse dto = new PaymentResponse(
                payment.getId(),
                payment.getCustomer().getName(),
                payment.getCustomer().getLicense().getPrice(),
                payment.getLastPayment()
        );

        if (payment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @GetMapping("payment/total")
    public ResponseEntity<?> getTotalPayment() {
        Double total = financeService.buscarTotalPagamentosUltimos30Dias();

        Map<String, Object> response = new HashMap<>();

        if (total != 0.0) {
            response.put("status", "pagamentos cadastrados");
            response.put("mensagem", "pagamentos encontrados");
            response.put("valor", total);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("status", "não encontrado");
            response.put("mensagem", "sem pagamento");
            response.put("valor", total);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

}
