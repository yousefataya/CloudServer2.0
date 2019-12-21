package com.experts.core.biller.statemachine.api.service.impl;



import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

import javax.jws.HandlerChain;
import javax.jws.WebService;

@RestController
@Configuration
@Endpoint
@WebService
@HandlerChain(file="handler-chain.xml")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T11:00:13.697Z[GMT]")
public class PaymentNotificationController {
}
