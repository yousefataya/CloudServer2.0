package com.experts.core.biller.statemachine.api.service.impl;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T11:00:13.697Z[GMT]")
public class PrimarySuccessResponse implements Serializable {

    @JsonProperty(value = "success")
    private String success;

    public static PrimarySuccessResponse create() {
        return PrimarySuccessResponse.builder().success("sucess").build();
    }

    public static PrimarySuccessResponse fail() {
        return PrimarySuccessResponse.builder().success("fail").build();
    }

    public static PrimarySuccessResponse phoneConditions() {
        return PrimarySuccessResponse.builder().success("Mobile Exist").build();
    }
}
