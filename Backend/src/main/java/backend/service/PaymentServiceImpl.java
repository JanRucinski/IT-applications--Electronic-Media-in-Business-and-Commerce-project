package backend.service;

import backend.model.Payment;
import backend.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment addPayment(Payment payment) {
        payment.setModifiedAt(OffsetDateTime.now());
        payment.setCreatedAt(OffsetDateTime.now());
        return paymentRepository.save(payment);
    }

    @Override
    public boolean deletePayment(Long id) {
        if (paymentRepository.existsById(id)) {
            paymentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Payment> findAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment updatePayment(Long id, Payment payment) {
        Optional<Payment> op = paymentRepository.findById(id);
        if (op.isPresent()) {
            op.get().setStatus(payment.getStatus());
            op.get().setModifiedAt(OffsetDateTime.now());
            return paymentRepository.save(op.get());
        }
        return null;
    }

    @Override
    public Payment findPaymentById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }
}
