package backend.service;

import backend.model.Payment;
import backend.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment addPayment(Payment payment) {
        return null;
    }

    @Override
    public Payment deletePayment(long id) {
        return null;
    }

    @Override
    public List<Payment> findAllPayments() {
        return null;
    }

    @Override
    public Payment updatePayment(Payment payment) {
        return null;
    }

    @Override
    public Payment findPaymentById(long id) {
        return null;
    }
}
