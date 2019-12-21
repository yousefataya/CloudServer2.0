package com.experts.core.biller.statemachine.api.service.impl.fastfood;

import com.experts.core.biller.statemachine.api.gigaspace.daos.repo.fastfood.BrandedFoodRepo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.fastfood.BrandedFood;
import com.experts.core.biller.statemachine.api.service.impl.dtos.billpull.fastfood.ActFoodRequest;
import com.experts.core.biller.statemachine.api.service.impl.dtos.billpull.fastfood.ActFoodResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FoodFastServiceController {

    @Autowired
    private BrandedFoodRepo brandedFoodRepo;

    @PostMapping("/order/fill")
    public ResponseEntity<ActFoodResponse> fillOrder(@RequestBody ActFoodRequest request){
        ActFoodResponse response = new ActFoodResponse();
        response.setDone(true);
        response.setInWay(true);
        response.setOrderNumber("100");
        response.setHeavyQueue(true);
        response.setDescription("Description Sandwitch");
        return  ResponseEntity.ok(response);
    }

    @PostMapping("/order/list")
    public ResponseEntity<List<BrandedFood>> listFoods(){
        ActFoodResponse response = new ActFoodResponse();
        List<BrandedFood> responses =  brandedFoodRepo.findAll();
        return  ResponseEntity.ok(responses);
    }
}
