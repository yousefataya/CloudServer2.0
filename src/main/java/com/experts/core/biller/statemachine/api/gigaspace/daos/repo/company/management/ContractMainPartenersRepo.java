package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.company.management;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.contract.ContractMainPartenerDocs;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.management.contract.ContractMainParteners;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.ws.rs.Consumes;

@Api(tags = "ContractMainParteners Entity")
@RepositoryRestResource(path = "ContractMainParteners" , collectionResourceRel = "ContractMainParteners")
@RestResource(exported = true ,path = "/service/ContractMainParteners" , rel = "/service/ContractMainParteners")
@Consumes("application/json")
public interface ContractMainPartenersRepo extends JpaRepository<ContractMainParteners, Long>{
}
