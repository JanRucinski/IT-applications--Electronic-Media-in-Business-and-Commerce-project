package backend.service;

import backend.model.Payment;

import java.util.List;

public interface PaymentService {
    Payment addPayment(Payment payment);
    Payment deletePayment(long id);
    List<Payment> findAllPayments();
    Payment updatePayment(Payment payment);
    Payment findPaymentById(long id);
}