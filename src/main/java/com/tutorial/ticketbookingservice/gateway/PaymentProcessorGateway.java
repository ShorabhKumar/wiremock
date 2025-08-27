package com.tutorial.ticketbookingservice.gateway;


import com.tutorial.ticketbookingservice.dto.PaymentProcessorResponse;
import com.tutorial.ticketbookingservice.dto.PaymentProcessorResponseRequest;
import com.tutorial.ticketbookingservice.dto.FraudCheckResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class PaymentProcessorGateway {

    private final RestTemplate restTemplate;
    public final String baseUrl = "http://localhost:8081";

    public PaymentProcessorGateway(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PaymentProcessorResponse makePayment(String creditCardNumber, LocalDate creditCardExpiry, Double amount) {
            final PaymentProcessorResponseRequest request = new PaymentProcessorResponseRequest(creditCardNumber, creditCardExpiry, amount);
        return restTemplate.postForObject(baseUrl + "/payments", request, PaymentProcessorResponse.class);
    }

    public void updatePayment(String bookingId) {
        restTemplate.postForObject(baseUrl + "/update", bookingId, Void.class);
    }

    public FraudCheckResponse fraudCheck(String cardNumber) {
        return restTemplate.getForObject(baseUrl + "/fraudCheck/"+cardNumber, FraudCheckResponse.class);
    }
}
