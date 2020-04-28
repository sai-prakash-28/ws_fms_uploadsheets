package com.cognizant.FeedBackSystem.dto.excel;

import io.github.mapper.excel.annotation.Column;
import lombok.Data;

import java.util.Date;

@Data
public class OutreachEventSummaryExcel {

    @Column(name ="Event ID")
    public String eventId;

    @Column(name ="Month")
    public String month;

    @Column(name ="Base Location")
    public String baseLocation;

    @Column(name ="Beneficiary Name")
    public String beneficiaryName;

    @Column(name ="Venue Address")
    public String venuAddress;

    @Column(name ="Council Name")
    public String councilName;

    @Column(name ="Project")
    public String project;

    @Column(name ="Category")
    public String category;

    @Column(name ="Event Name")
    public String eventName;

    @Column(name ="Event Description")
    public String eventDescription;

    @Column(name ="Event Date (DD-MM-YY)", pattern = "dd-MM-yy")
    public Date eventDate;

    @Column(name ="Total no. of volunteers")
    public Integer totalNoOfVolunteers;

    @Column(name ="Total Volunteer Hours")
    public Double totalvolunteerHours;

    @Column(name ="Total Travel Hours")
    public Double totalTravelHours;

    @Column(name ="Overall Volunteering Hours")
    public Double overAllVolunteeringHours;

    @Column(name ="Lives Impacted")
    public Integer livesImpacted;

    @Column(name ="Activity Type")
    public Integer activityType;

    @Column(name ="Status")
    public String status;

    @Column(name ="POC ID")
    public Integer POC_ID;

    @Column(name ="POC Name")
    public String POC_name;

    @Column(name ="POC Contact Number")
    public String POC_Contact_name;

}
