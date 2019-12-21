package com.experts.core.biller.statemachine.api.rovo.awsxray.domain.views;

import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.DomainObject;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;


public class BaseViewEntity implements DomainObject {

    @Id
    protected String id;
    protected String uuid;

    protected boolean disabled = false;

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getUuid() {
        return this.uuid;
    }

    public Boolean getDisabled() {
        return disabled;
    }
}
