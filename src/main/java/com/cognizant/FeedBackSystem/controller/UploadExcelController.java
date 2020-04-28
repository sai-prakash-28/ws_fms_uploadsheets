package com.cognizant.FeedBackSystem.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cognizant.FeedBackSystem.contsants.ConstantWords;
import com.cognizant.FeedBackSystem.service.ExcelReadService;
import com.cognizant.FeedBackSystem.utils.FileOperations;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@AllArgsConstructor
@Slf4j
public class UploadExcelController implements ErrorController {

    private final ExcelReadService excelReadService;


    public static final String uploadingDir = System.getProperty("user.dir") + "/uploadingDir/";

    @GetMapping("/upload")
    public String uploading(Model model) {
        File file = new File(uploadingDir);
        model.addAttribute("files", file.listFiles());
        return "uploading";
    }

    @PostMapping(value = "/upload")
    public String uploadingPost(@RequestParam("uploadingFiles") MultipartFile[] uploadingFiles) throws IOException {
        log.info("The file which are upload as follows");
        Arrays.stream(uploadingFiles).filter(Objects::nonNull).forEach(p -> log.info("]]]]===>> " + FileOperations.getFileNameString(p.getOriginalFilename())));

        for (MultipartFile uploadedFile : uploadingFiles) {

            File file = new File(uploadingDir + uploadedFile.getOriginalFilename());
            uploadedFile.transferTo(file);

            if (ConstantWords.LIST_OF_EXCEL.contains(FileOperations.getFileName(file))) {
                log.info("Processing the file " + file.getName());

                try {
                    String res = excelReadService.readExcel(file);

                } catch (Throwable throwable) {
                    log.error("Error occureload while processing the files"+file.getName());

                    throwable.printStackTrace();

                }

            } else {
                System.out.println("the file name are worng");
            }

        }


        return "redirect:/upload";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
    @RequestMapping("/error")
    public String handleError() {
        return "error";
    }
}
