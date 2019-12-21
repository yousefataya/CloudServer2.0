package com.experts.core.biller.statemachine.api.service.impl.dtos.billpull.fastfood;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class ActFoodRequest implements Serializable {
    private String uuid;
    private String orderName;
    private String customerName;
    private String customerMobile;
    private boolean isExpired;
    private String description;
    private String size;
    private String locations;
    private String number;
}
