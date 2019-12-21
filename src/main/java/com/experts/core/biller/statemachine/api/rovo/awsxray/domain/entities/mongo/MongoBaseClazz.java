package com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*import org.hibernate.annotations.UpdateTimestamp;*/
import org.hibernate.annotations.UpdateTimestamp;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Version;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MongoBaseClazz{

    @Id
    public String id;

    public String uuid;

    @CreatedDate
    public Date creationDate;

    @UpdateTimestamp
    public Date lastChange;

    @Version
    public long version;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((uuid == null) ? 0 : uuid.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        BaseEntity other = (BaseEntity) obj;
        if (uuid == null) {
            return false;
        } else if (uuid.equals(other.uuid)) {
            return true;
        }
        return false;
    }
}
