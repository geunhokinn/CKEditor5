package com.example.ckeditor5.controller;

import com.example.ckeditor5.dto.UploadDTO;
import com.example.ckeditor5.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/image/upload")
    public UploadDTO imageUpload(@RequestPart(value = "upload") MultipartFile multipartFile) {

        return imageService.imageUpload(multipartFile);
    }
}
