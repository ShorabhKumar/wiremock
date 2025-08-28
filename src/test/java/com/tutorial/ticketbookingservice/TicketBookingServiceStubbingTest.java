package com.tutorial.ticketbookingservice;

import com.tutorial.ticketbookingservice.dto.CardDetails;
import com.tutorial.ticketbookingservice.dto.PaymentUpdateResponse;
import com.tutorial.ticketbookingservice.dto.TicketBookingPaymentRequest;
import com.tutorial.ticketbookingservice.gateway.PaymentProcessorGateway;
import com.tutorial.ticketbookingservice.service.TicketBookingService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketBookingServiceStubbingTest {
    private TicketBookingService ticketBookingService;

    @BeforeEach
    void setUp() {
        PaymentProcessorGateway paymentProcessorGateway = new PaymentProcessorGateway("localhost",8081,new RestTemplate());
        ticketBookingService = new TicketBookingService(paymentProcessorGateway);
    }

    @Test
    void updatePaymentDetailsTest(){
        //when
        TicketBookingPaymentRequest bookingPayment = new TicketBookingPaymentRequest("1111",200.0,
                new CardDetails("1111-1111-1111", LocalDate.now()));

        PaymentUpdateResponse response =  ticketBookingService.updatePaymentDetails(bookingPayment);

        //then
        assertThat(response.getStatus()).isEqualTo("SUCCESS");
    }

    @AfterEach
    void tearDown() {
    }
}
