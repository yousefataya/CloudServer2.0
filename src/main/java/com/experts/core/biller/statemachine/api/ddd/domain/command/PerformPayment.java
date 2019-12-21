package com.experts.core.biller.statemachine.api.ddd.domain.command;

import com.experts.core.biller.statemachine.api.ddd.domain.vo.CustomerId;
import com.experts.core.biller.statemachine.api.ddd.domain.vo.PaymentIntent;
import com.experts.core.biller.statemachine.api.ddd.domain.vo.PaymentMethod;
import com.experts.core.biller.statemachine.api.ddd.domain.vo.Transaction;
import lombok.Value;

import java.time.LocalDateTime;

@Value(staticConstructor = "commandOf")
public class PerformPayment implements PaymentCommand {
    private  CustomerId customerId;
    private  PaymentIntent paymentIntent;
    private  PaymentMethod paymentMethod;
    private  Transaction transaction;
    private final LocalDateTime timestamp = LocalDateTime.now();
}
