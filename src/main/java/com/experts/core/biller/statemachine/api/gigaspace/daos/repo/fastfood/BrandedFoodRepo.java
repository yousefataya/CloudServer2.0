package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.fastfood;


import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.performance.TaskIssueFaces;
import com.experts.core.biller.statemachine.api.model.domain.jpa.fastfood.BrandedFood;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "BrandedFood Entity")
@RepositoryRestResource(path = "BrandedFood" , collectionResourceRel = "BrandedFood")
@RestResource(exported = true ,path = "/service/BrandedFood" , rel = "/service/BrandedFood")
@Consumes("application/json")
public interface BrandedFoodRepo extends JpaRepository<BrandedFood, Long> {
}
