package com.experts.core.biller.statemachine.api.service.impl.dtos.billpull.fastfood;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ActFoodResponse implements Serializable {
    private boolean isExpired;
    private String description;
    private boolean done;
    private boolean inWay;
    private boolean heavyQueue;
    private String orderNumber;
}
