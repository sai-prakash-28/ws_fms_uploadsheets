package com.cognizant.FeedBackSystem.mapper;


import com.cognizant.FeedBackSystem.entity.OutreachEventInformation;
import com.cognizant.FeedBackSystem.entity.OutreachEventSummary;
import com.cognizant.FeedBackSystem.entity.VolunteerEnrollmentDetailsNotAttend;
import com.cognizant.FeedBackSystem.entity.VolunteerEnrollmentDetailsUnregistered;
import com.cognizant.FeedBackSystem.dto.excel.OutreachEventInformationExcel;
import com.cognizant.FeedBackSystem.dto.excel.OutreachEventSummaryExcel;
import com.cognizant.FeedBackSystem.dto.excel.VolunteerEnrollmentDetailsNotAttendExcel;
import com.cognizant.FeedBackSystem.dto.excel.VolunteerEnrollmentDetailsUnregisteredExcel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExcelToDtoObjMapper {

    OutreachEventInformation getObj(OutreachEventInformationExcel outreachEventInformationExcel);

    OutreachEventSummary getObj(OutreachEventSummaryExcel outreachEventSummaryExcel);

    VolunteerEnrollmentDetailsNotAttend getObj(VolunteerEnrollmentDetailsNotAttendExcel volunteerEnrollmentDetailsNotAttendExcel);

    VolunteerEnrollmentDetailsUnregistered getObj(VolunteerEnrollmentDetailsUnregisteredExcel volunteerEnrollmentDetailsUnregisteredExcel);

}
