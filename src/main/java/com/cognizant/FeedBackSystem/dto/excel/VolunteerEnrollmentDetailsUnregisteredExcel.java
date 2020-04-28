package com.cognizant.FeedBackSystem.dto.excel;

import io.github.mapper.excel.annotation.Column;
import lombok.Data;

import java.util.Date;

@Data
public class VolunteerEnrollmentDetailsUnregisteredExcel {

    @Column(name ="Event ID")
    public String eventId;

    @Column(name ="Event Name")
    public String eventName;

    @Column(name ="Beneficiary Name")
    public String beneficiaryName;

    @Column(name ="Base Location")
    public String baseLocation;

    @Column(name ="Event Date (DD-MM-YY)", pattern = "dd-MM-yy")
    public Date eventDate;

    @Column(name ="EmployeeID")
    public Integer employeeId;

}
