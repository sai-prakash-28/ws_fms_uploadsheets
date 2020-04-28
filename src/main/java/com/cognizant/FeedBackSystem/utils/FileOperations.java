package com.cognizant.FeedBackSystem.utils;


import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.lang.reflect.Field;

@Component
public class FileOperations {

    public static boolean checkNotNullObjects(Object obj) {
        for (Field f : obj.getClass().getDeclaredFields()) {
            try {
                if (f.get(obj) != null)
                    return true;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static  String getFileName(File file){
        return getFileNameString(file.toString());
    }

    public static String getFileNameString(String file) {
        return FilenameUtils.removeExtension(FilenameUtils.getName(file));
    }

}
