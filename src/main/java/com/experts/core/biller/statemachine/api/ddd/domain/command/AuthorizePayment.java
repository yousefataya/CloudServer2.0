package com.experts.core.biller.statemachine.api.ddd.domain.command;

import com.experts.core.biller.statemachine.api.ddd.domain.vo.CustomerId;
import com.experts.core.biller.statemachine.api.ddd.domain.vo.PaymentId;
import com.experts.core.biller.statemachine.api.ddd.domain.vo.PaymentMethod;
import com.experts.core.biller.statemachine.api.ddd.domain.vo.Transaction;
import lombok.*;

import java.time.LocalDateTime;

@Value(staticConstructor = "commandOf")
public class AuthorizePayment implements PaymentCommand {
    private  PaymentId paymentId;
    private  CustomerId customerId;
    private  PaymentMethod paymentMethod;
    private  Transaction transaction;
    private  LocalDateTime timestamp = LocalDateTime.now();
}
