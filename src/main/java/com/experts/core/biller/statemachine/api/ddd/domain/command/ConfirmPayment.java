package com.experts.core.biller.statemachine.api.ddd.domain.command;

import com.experts.core.biller.statemachine.api.ddd.domain.vo.CustomerId;
import com.experts.core.biller.statemachine.api.ddd.domain.vo.PaymentId;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.time.LocalDateTime;

@Value(staticConstructor = "commandOf")
public class ConfirmPayment implements PaymentCommand {
    private  PaymentId paymentId;
    private  CustomerId customerId;
    private  LocalDateTime timestamp = LocalDateTime.now();
}
