package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.holiday.lookup;


import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.holiday.EmployeeHoliday;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name  = "hr_employee_holiday_lookup")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class EmployeeHolidayLookup extends BaseEntity {

    @Column(name  = "description" , nullable = true)
    private String desscription;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "holiday_type" , nullable = false)
    private String holidayType;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "employeeHolidayLookup")
    private List<EmployeeHoliday> employeeHolidays;
}
