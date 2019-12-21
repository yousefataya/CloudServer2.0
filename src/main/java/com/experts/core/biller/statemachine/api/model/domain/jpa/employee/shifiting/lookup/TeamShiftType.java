package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.shifiting.lookup;

import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.shifiting.EmployeeTeamShifting;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "team_shift_type")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class TeamShiftType extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String description;

    @Column(name = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name  = "shift_type" , nullable = false)
    private String shiftType;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "teamShiftType")
    private List<EmployeeTeamShifting> employeeTeamShiftings;
}
