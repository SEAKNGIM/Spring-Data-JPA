package org.example.restfullsimplejpa.service.serviceImpl;

import org.example.restfullsimplejpa.service.FileStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Service
public class FileStorageServiceImpl implements FileStorageService {
    @Value("${file_storage.image_location}")
    String fileStorageLocation;

    @Override
    public String uploadSingleFile(MultipartFile file) {
        try {

            Path imageStoragePath = Path.of(fileStorageLocation);
            if (!Files.exists(imageStoragePath)) {
                Files.createDirectories(imageStoragePath);
            }
//            destination => q304573904587204101.png
            String newFileName= UUID.randomUUID()+"."+
                    file.getOriginalFilename().split("\\.")[1];

            // imageFullPath = filestorage/images/asfasdflasf2w3er2.png
            Path imageFullPath = imageStoragePath.resolve(newFileName);
            Files.copy(
                    file.getInputStream(),
                    imageFullPath,
                    StandardCopyOption.REPLACE_EXISTING
            );

            return newFileName;
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Failed to upload a file ! ");
        }

        return null;
    }

    @Override
    public List<String> uploadMultipleFiles(MultipartFile[] files) {
        return null;
    }

    @Override
    public void deleteFileByName(String filename) {

    }

}
