package backend.service;

import backend.model.Payment;

import java.util.List;

public interface PaymentService {
    Payment addPayment(Payment payment);

    boolean deletePayment(Long id);

    List<Payment> findAllPayments();

    Payment updatePayment(Long id, Payment payment);

    Payment findPaymentById(Long id);
}