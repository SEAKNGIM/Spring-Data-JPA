package org.example.restfullsimplejpa.restcontroller;

import lombok.RequiredArgsConstructor;
import org.example.restfullsimplejpa.service.FileStorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/files")
@RequiredArgsConstructor

public class FileStorageRestController {
    private final FileStorageService fileStorageService;


    @PostMapping(value = "",consumes = {"multipart/form-data"})
    public HashMap<String,Object> uploadFile(@RequestPart("file") MultipartFile file){
        HashMap<String,Object > response = new HashMap<>();
        response.put("payload", fileStorageService.uploadSingleFile(file))
        ;
        return response;
    }

}
