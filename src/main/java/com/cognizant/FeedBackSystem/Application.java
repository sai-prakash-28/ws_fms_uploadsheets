package com.cognizant.FeedBackSystem;

import com.cognizant.FeedBackSystem.controller.UploadExcelController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

import java.io.File;
import java.io.IOException;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class Application {
    public static void main(String[] args) throws IOException {
        new File(UploadExcelController.uploadingDir).mkdirs();
        SpringApplication.run(Application.class, args);
    }
}