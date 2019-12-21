package com.experts.core.biller.statemachine.api.rules;


import com.experts.core.biller.statemachine.api.constants.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

@Data
@AllArgsConstructor
/*@NoArgsConstructor*/
@Builder

public class PayProcessValidationRequest implements Serializable {


    private InitialStateValidationRequest transaction;
    private String amount;
    private Currency currency;
    private String bankCode;
    private boolean isSuccesRule;

    public PayProcessValidationRequest(InitialStateValidationRequest transaction , String amount , Currency currency , String bankCode) {
        this.amount = amount;
        this.bankCode = bankCode;
        this.currency = currency;
        this.transaction = transaction;
    }
    public boolean when(){

     if(StringUtils.isBlank(amount) || StringUtils.isEmpty(amount) || StringUtils.isAlpha(amount)){

     }

     if(StringUtils.isBlank(Currency.USD.toString()) || StringUtils.isBlank(Currency.USD.toString()) || !StringUtils.isAlphanumeric(Currency.USD.toString())){

     }
     return isSuccesRule;
    }


    public static class Builder {

        private InitialStateValidationRequest transaction;

        private String amount;

        private Currency currency;

        private String bankCode;


        public Builder transaction(InitialStateValidationRequest transaction){
            this.transaction = transaction;
            return this;
        }

        public Builder amount(String amount){
            this.amount = amount;
            return this;
        }

        public Builder currency(Currency currency){
            this.currency = currency;
            return this;
        }

        public Builder bankCode(String bankCode){
            this.bankCode = bankCode;
            return this;
        }

        public PayProcessValidationRequest build(){
            return new PayProcessValidationRequest(transaction , amount , currency , bankCode);
        }
    }

}
