package com.ms.hrpayroll.service;

import com.ms.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long worderId, int days) {
        return new Payment("Daniel", 16000.0, days);
    }

}
