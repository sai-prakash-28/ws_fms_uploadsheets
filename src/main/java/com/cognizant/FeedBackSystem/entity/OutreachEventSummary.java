package com.cognizant.FeedBackSystem.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class OutreachEventSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String outreachEventSummaryId;

    private String eventId;

    private String month;

    private String baseLocation;

    private String beneficiaryName;

    private String venuAddress;

    private String councilName;

    private String project;

    private String category;

    private String eventName;

    private String eventDescription;

    private Date eventDate;

    private Integer totalNoOfVolunteers;

    private Double totalvolunteerHours;

    private Double totalTravelHours;

    private Double overAllVolunteeringHours;

    private Integer livesImpacted;

    private Integer activityType;

    private String status;

    private Integer POC_ID;

    private String POC_name;

    private String POC_Contact_name;

    @CreationTimestamp
    private LocalDateTime createdTimeStamp;
    @UpdateTimestamp
    private LocalDateTime updatedTimeStamp;
}
