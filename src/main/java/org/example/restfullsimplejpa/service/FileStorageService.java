package org.example.restfullsimplejpa.service;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;

public interface FileStorageService {

    String uploadSingleFile(MultipartFile file);
    List<String> uploadMultipleFiles(MultipartFile[] files);
    void  deleteFileByName(String filename);

//    List<String>uploadMultipleFiles(MultipartFile file);

}
