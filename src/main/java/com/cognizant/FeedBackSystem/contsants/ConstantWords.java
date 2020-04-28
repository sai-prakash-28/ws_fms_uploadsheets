package com.cognizant.FeedBackSystem.contsants;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstantWords {

    public static final Integer LIST_SPLIT_SIZE = 50;

    public static final String VEDNA = "Volunteer_Enrollment Details_Not_Attend";
    public static final String VEDU = "Volunteer_Enrollment Details_Unregistered";
    public static final String OES = "outreach event summary";
    public static final String OEI = "outreach event information";
    public static final List<String> LIST_OF_EXCEL = new ArrayList<>(Arrays.asList(VEDNA, VEDU, OES, OEI));

    public static final List<String> LIST_OF_OEI = new ArrayList<>(Arrays.asList("Event ID", "Base Location",
            "Beneficiary Name", "Council Name", "Event Name", "Event Description", "Event Date (DD-MM-YY)",
            "Employee ID", "Employee Name", "Volunteer Hours", "Travel Hours", "Lives Impacted", "Business Unit",
            "Status", "IIEP Category"));


    public static final String XLSX = ".xlsx";
    public static final String XLS = ".xls";
}
