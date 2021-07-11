package com.ms.hrpayroll.service;

import com.ms.hrpayroll.entities.Payment;
import com.ms.hrpayroll.entities.Worker;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerBaseUrl;

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(long workerId, int days) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", ""+workerId);

        Worker worker = restTemplate
                .getForObject(workerBaseUrl+"/workers/{id}", Worker.class, uriVariables);
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
