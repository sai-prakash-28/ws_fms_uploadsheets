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
public class VolunteerEnrollmentDetailsNotAttend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String volunteerEnrollmentDetailsNotAttendId;

    public String eventId;


    public String eventName;


    public String beneficiaryName;


    public String baseLocation;


    public Date eventDate;

    public Integer employeeId;

    @CreationTimestamp
    private LocalDateTime createdTimeStamp;
    @UpdateTimestamp
    private LocalDateTime updatedTimeStamp;
}
