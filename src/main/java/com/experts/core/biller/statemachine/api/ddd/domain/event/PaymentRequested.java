package com.experts.core.biller.statemachine.api.ddd.domain.event;

import com.experts.core.biller.statemachine.api.ddd.domain.vo.*;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.time.LocalDateTime;

@Value(staticConstructor = "eventOf")
public class PaymentRequested implements PaymentEvent {
    private  PaymentEventId eventId = new PaymentEventId();
    private  PaymentId paymentId;
    private  CustomerId customerId;
    private  PaymentIntent paymentIntent;
    private  PaymentMethod paymentMethod;
    private  Transaction transaction;
    private  LocalDateTime timestamp;

    @Override
    public PaymentEventId getEventId() {
        return eventId;
    }

    @Override
    public PaymentEventType getEventType() {
        return PaymentEventType.PAYMENT_REQUESTED;
    }

    @Override
    public PaymentId getPaymentId() {
        return paymentId;
    }

    @Override
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

}
