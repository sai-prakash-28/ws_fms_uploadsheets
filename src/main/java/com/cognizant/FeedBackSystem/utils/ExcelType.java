package com.cognizant.FeedBackSystem.utils;

import com.cognizant.FeedBackSystem.contsants.ConstantWords;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class ExcelType {

    public static boolean isXLSX(File file){
        String fileName =  file.getName();
        String fileExtensionName = fileName.substring(fileName.indexOf("."));
        return fileExtensionName.equals(ConstantWords.XLSX);
    }

    public static boolean isXLS(File file){
        String fileName =  file.getName();
        String fileExtensionName = fileName.substring(fileName.indexOf("."));
        return fileExtensionName.equals(ConstantWords.XLS);
    }

}
