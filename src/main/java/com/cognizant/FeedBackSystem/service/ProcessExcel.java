package com.cognizant.FeedBackSystem.service;

import com.cognizant.FeedBackSystem.entity.OutreachEventInformation;
import com.cognizant.FeedBackSystem.entity.OutreachEventSummary;
import com.cognizant.FeedBackSystem.entity.VolunteerEnrollmentDetailsNotAttend;
import com.cognizant.FeedBackSystem.dto.excel.OutreachEventSummaryExcel;
import com.cognizant.FeedBackSystem.entity.VolunteerEnrollmentDetailsUnregistered;
import com.cognizant.FeedBackSystem.mapper.ExcelToDtoObjMapper;
import com.cognizant.FeedBackSystem.contsants.ConstantWords;
import com.cognizant.FeedBackSystem.dto.excel.OutreachEventInformationExcel;
import com.cognizant.FeedBackSystem.dto.excel.VolunteerEnrollmentDetailsNotAttendExcel;
import com.cognizant.FeedBackSystem.dto.excel.VolunteerEnrollmentDetailsUnregisteredExcel;
import com.cognizant.FeedBackSystem.repository.OutreachEventInformationRepository;
import com.cognizant.FeedBackSystem.repository.OutreachEventSummaryRepository;
import com.cognizant.FeedBackSystem.repository.VolunteerEnrollmentDetailsNotAttendRepository;

import com.cognizant.FeedBackSystem.repository.VolunteerEnrollmentDetailsUnregisteredRepository;
import com.cognizant.FeedBackSystem.utils.ExcelType;
import com.cognizant.FeedBackSystem.utils.FileOperations;
import io.github.mapper.excel.ExcelMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ProcessExcel {

    private final ExcelToDtoObjMapper excelToDtoObjMapper;
    private final OutreachEventInformationRepository outreachEventInformationRepository;
    private final OutreachEventSummaryRepository outreachEventSummaryRepository;
    private final VolunteerEnrollmentDetailsNotAttendRepository volunteerEnrollmentDetailsNotAttendRepository;
    private final VolunteerEnrollmentDetailsUnregisteredRepository volunteerEnrollmentDetailsUnregisteredRepository;

    public String processOEI(File file) throws Throwable {

        if (ExcelType.isXLSX(file)) {

            List<OutreachEventInformationExcel> items = null;
			try {
				items = ExcelMapper.mapFromExcel(file)
				        .toObjectOf(OutreachEventInformationExcel.class)
				        .map();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				
			}
            List<OutreachEventInformationExcel> finalNonNullvlaues = items.stream().filter(FileOperations::checkNotNullObjects).collect(Collectors.toList());

            List<OutreachEventInformation> outreachEventInformationList = finalNonNullvlaues.parallelStream().map(excelToDtoObjMapper::getObj).collect(Collectors.toList());

            outreachEventInformationRepository.saveAll(outreachEventInformationList);

            log.info("Sucessfully saved " + ConstantWords.OEI);


            return "ok i believe";
        } else {
            return "Unknown Excel type , Sorry!!";
        }

    }

    public String processOES(File file) throws Throwable {

        if (ExcelType.isXLSX(file)) {

            List<OutreachEventSummaryExcel> items = ExcelMapper.mapFromExcel(file)
                    .toObjectOf(OutreachEventSummaryExcel.class)
                    .map();
            List<OutreachEventSummaryExcel> finalNonNullvlaues = items.stream().filter(FileOperations::checkNotNullObjects).collect(Collectors.toList());

            List<OutreachEventSummary> outreachEventSummaries = finalNonNullvlaues.parallelStream().map(excelToDtoObjMapper::getObj).collect(Collectors.toList());

            outreachEventSummaryRepository.saveAll(outreachEventSummaries);

            log.info("Sucessfully saved " + ConstantWords.OES);

            return "ok i believe";

        } else {
            return "Unknown Excel type , Sorry!!";
        }
    }

    public String processVEDNA(File file) throws Throwable {

        if (ExcelType.isXLSX(file)) {

            List<VolunteerEnrollmentDetailsNotAttendExcel> items = ExcelMapper.mapFromExcel(file)
                    .toObjectOf(VolunteerEnrollmentDetailsNotAttendExcel.class)
                    .map();
            List<VolunteerEnrollmentDetailsNotAttendExcel> finalNonNullvlaues = items.stream().filter(FileOperations::checkNotNullObjects).collect(Collectors.toList());

            List<VolunteerEnrollmentDetailsNotAttend> volunteerEnrollmentDetailsNotAttendList = finalNonNullvlaues.parallelStream().map(excelToDtoObjMapper::getObj).collect(Collectors.toList());

            volunteerEnrollmentDetailsNotAttendRepository.saveAll(volunteerEnrollmentDetailsNotAttendList);

            log.info("Sucessfully saved " + ConstantWords.VEDNA);

            return "done";


        } else {
            return "Unknown Excel type , Sorry!!";
        }
    }

    public String processVEDU(File file) throws Throwable {
        if (ExcelType.isXLSX(file)) {

            List<VolunteerEnrollmentDetailsUnregisteredExcel> items = ExcelMapper.mapFromExcel(file)
                    .toObjectOf(VolunteerEnrollmentDetailsUnregisteredExcel.class)
                    .map();
            List<VolunteerEnrollmentDetailsUnregisteredExcel> finalNonNullvlaues = items.stream().filter(FileOperations::checkNotNullObjects).collect(Collectors.toList());

            List<VolunteerEnrollmentDetailsUnregistered> volunteerEnrollmentDetailsUnregisteredList = finalNonNullvlaues.parallelStream().map(excelToDtoObjMapper::getObj).collect(Collectors.toList());

            volunteerEnrollmentDetailsUnregisteredRepository.saveAll(volunteerEnrollmentDetailsUnregisteredList);


            log.info("Sucessfully saved " + ConstantWords.VEDU);


            return "ok i believe";


        } else {
            return "Unknown Excel type , Sorry!!";
        }
    }
}
