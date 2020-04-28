package com.cognizant.FeedBackSystem.service;


import com.cognizant.FeedBackSystem.contsants.ConstantWords;
import com.cognizant.FeedBackSystem.utils.FileOperations;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@AllArgsConstructor
public class ExcelReadService {

    private final ProcessExcel processExcel;

    public String readExcel(File file) throws Throwable {

        if (ConstantWords.OEI.equals(FileOperations.getFileName(file))) {
            System.out.println("processing the file " + file);
            String res = processExcel.processOEI(file);
        }
        if (ConstantWords.OES.equals(FileOperations.getFileName(file))) {
            String res = processExcel.processOES(file);
        }
        if (ConstantWords.VEDNA.equals(FileOperations.getFileName(file))) {
            String res = processExcel.processVEDNA(file);
        }
        if (ConstantWords.VEDU.equals(FileOperations.getFileName(file))) {
            String res = processExcel.processVEDU(file);
        }


        return null;
    }


}
