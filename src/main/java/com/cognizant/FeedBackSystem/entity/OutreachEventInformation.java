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
@NoArgsConstructor
@AllArgsConstructor
public class OutreachEventInformation {


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private String outreachEventInformationId;
    private String eventId;
    private String baseLocation;
    private String beneficiaryName;
    private String councilName;
    private String eventName;
    private String eventDescription;
    private Date eventDate;
    private Integer employeeId;
    private String employeeName;
    private Double volunteerHours;
    private Double travelHours;
    private Integer livesImpacted;
    private String businessUnit;
    private String status;
    private String IIEPcategory;

    @CreationTimestamp
    private LocalDateTime createdTimeStamp;
    @UpdateTimestamp
    private LocalDateTime updatedTimeStamp;
}
