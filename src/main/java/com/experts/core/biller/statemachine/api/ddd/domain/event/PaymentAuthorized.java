package com.experts.core.biller.statemachine.api.ddd.domain.event;

import com.experts.core.biller.statemachine.api.ddd.domain.vo.*;
import lombok.*;

import java.time.LocalDateTime;

@Value(staticConstructor = "eventOf")
public class PaymentAuthorized implements PaymentEvent {
    private  PaymentEventId eventId = new PaymentEventId();
    private  PaymentId paymentId;
    private  CustomerId customerId;
    private  PaymentMethod paymentMethod;
    private  Transaction transaction;
    private  LocalDateTime timestamp;

    @Override
    public PaymentEventId getEventId() {
        return eventId;
    }

    @Override
    public PaymentEventType getEventType() {
        return PaymentEventType.PAYMENT_AUTHORIZED;
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
