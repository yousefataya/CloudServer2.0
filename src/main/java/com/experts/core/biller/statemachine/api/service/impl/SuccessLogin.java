package com.experts.core.biller.statemachine.api.service.impl;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T11:00:13.697Z[GMT]")
public class SuccessLogin {

    private String j_username;

    private String j_password;
}
