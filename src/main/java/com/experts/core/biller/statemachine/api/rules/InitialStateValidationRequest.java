package com.experts.core.biller.statemachine.api.rules;


import com.experts.core.biller.statemachine.api.rules.facts.RuleMessageFactsResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Data

public class InitialStateValidationRequest {

    private boolean isSuccessRule = true;
    private String billCode;
    private String billName;
    private String billerName;
    private String billerCode;
    private String billerAddress;
    private String clientId;
    private String onServiceBy;
    private String bankId;
    private String bankName;
    private String bankAddress;
    private String bankCode;


    private List<RuleMessageFactsResponse> response;

    public InitialStateValidationRequest(String billCode , String billName , String billerName , String billerCode , String billerAddress , String clientId , String onServiceBy , String bankId , String bankName , String bankAddress , String bankCode ){
        this.billCode =  billCode;
        this.billName = billName;
        this.billerCode = billerCode;
        this.billerName = billerName;
        this.billerAddress = billerAddress;
        this.clientId = clientId;
        this.onServiceBy = onServiceBy;
        this.bankId = bankId;
        this.bankAddress = bankAddress;
        this.bankCode = bankCode;
        this.bankName = bankName;
    }


    public boolean when(){

        if(!StringUtils.isBlank(billCode) || StringUtils.isEmpty(billCode)){

        }

        if(StringUtils.isBlank(billName) || StringUtils.isEmpty(billName)){

        }

        if(StringUtils.isBlank(billerAddress) || StringUtils.isEmpty(billerAddress)){

        }

        if(StringUtils.isBlank(billerCode) || StringUtils.isEmpty(billerCode)){

        }

        if(StringUtils.isBlank(billerName) || StringUtils.isEmpty(billerName)){

        }

        if(StringUtils.isBlank(bankId) || StringUtils.isEmpty(bankId)){

        }

        if(StringUtils.isBlank(bankName) || StringUtils.isEmpty(bankName)){

        }

        if(StringUtils.isBlank(clientId) || StringUtils.isEmpty(clientId)){

        }
        return isSuccessRule;
    }


    public void then() {
        /*result = hello + " ";*/
    }

    public static class Builder {

        private String billCode;
        private String billName;
        private String billerName;
        private String billerCode;
        private String billerAddress;
        private String clientId;
        private String onServiceBy;
        private String bankId;
        private String bankName;
        private String bankAddress;
        private String bankCode;

        public Builder billCode(String billCode){
            this.billCode = billCode;
            return this;
        }

        public Builder billName(String billName){
            this.billName = billName;
            return this;
        }

        public Builder billerName(String billerName){
            this.billerName = billerName;
            return this;
        }

        public Builder billerCode(String billerCode){
            this.billerCode = billerCode;
            return this;
        }

        public Builder billerAddress(String billerAddress){
            this.billerAddress = billerAddress;
            return this;
        }

        public Builder clientId(String client){
            this.clientId = clientId;
            return this;
        }

        public Builder onServiceBy(String onServiceBy){
            this.onServiceBy = onServiceBy;
            return this;
        }

        public Builder bankId(String bankId){
            this.bankId = bankId;
            return this;
        }

        private Builder bankName(String bankName){
            this.bankName = bankName;
            return this;
        }

        public Builder bankAddress(String billerAddress){
            this.bankAddress = bankAddress;
            return this;
        }

        public Builder bankCode(String bankCode){
            this.bankCode = bankCode;
            return this;
        }

        public InitialStateValidationRequest build(){
            return new InitialStateValidationRequest(billCode , billName , billerName , billerCode , billerAddress , clientId , onServiceBy ,  bankId , bankName , bankAddress , bankCode );
        }
    }


}
