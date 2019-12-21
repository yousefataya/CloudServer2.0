package com.experts.core.biller.statemachine.api.model.domain.jpa.employee.leave;

import com.arjuna.common.internal.util.propertyservice.ConcatenationPrefix;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.EmployeeInfo;
import com.experts.core.biller.statemachine.api.model.domain.jpa.employee.leave.lookup.EmployeeLeaveLookup;
import com.experts.core.biller.statemachine.api.rovo.awsxray.domain.entities.mongo.BaseEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name  = "employee_leave_hr")
@Data
@Builder
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class EmployeeLeaveManage extends BaseEntity {

    @Column(name = "description" , nullable = true)
    private String description;

    @Column(name  = "notes" , nullable = true)
    private String notes;

    @Column(name  = "expired" , nullable = false)
    private boolean isExpired;

    @Column(name="leave_name" , nullable = false)
    private String leaveName;

    @Column(name  = "leave_reason" , nullable = false)
    private String leaveReason;

    @ManyToOne(fetch = FetchType.LAZY , cascade =  CascadeType.ALL)
    @JoinColumn(name  = "employee_info" , nullable = false)
    private EmployeeInfo employeeInfo;

    /* business process management Id */

    /* employee reference key */

    @Column(name  = "from_date" , nullable = false)
    @Temporal(TemporalType.TIME)
    private Date fromDate;


    @Column(name  = "to_date" , nullable = false)
    @Temporal(TemporalType.TIME)
    private Date toDate;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "manager_id" , nullable = true)
    private EmployeeInfo manager;

    /* employee reference key take the decision*/

    @Column(name  = "max_time" , nullable = false)
    @Temporal(TemporalType.TIME)
    private Date maxTime;

    @Column(name  = "mobile_no" , nullable = false)
    private String mobileNo;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name  = "employee_leave_lookup" , nullable = false)
    private EmployeeLeaveLookup employeeLeaveLookup;

    /* reference key employee leave lookup*/

}
