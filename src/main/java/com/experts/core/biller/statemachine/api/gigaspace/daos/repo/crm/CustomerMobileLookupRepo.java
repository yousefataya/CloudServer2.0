package com.experts.core.biller.statemachine.api.gigaspace.daos.repo.crm;
import com.experts.core.biller.statemachine.api.model.domain.jpa.crm.contact.lookup.CustomerMobileLookup;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import javax.ws.rs.Consumes;

@Api(tags = "CustomerMobileLookup Entity")
@RepositoryRestResource(path = "CustomerMobileLookup" , collectionResourceRel = "CustomerMobileLookup")
@RestResource(exported = true ,path = "/service/CustomerMobileLookup" , rel = "/service/CustomerMobileLookup")
@Consumes("application/json")
public interface CustomerMobileLookupRepo extends JpaRepository<CustomerMobileLookup, Long> {
}
