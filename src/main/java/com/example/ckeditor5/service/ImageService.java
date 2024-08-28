package com.example.ckeditor5.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.ckeditor5.dto.UploadDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ImageService {

    private static final String ROOT_PATH = System.getProperty("user.dir");
    private static final String LOCAL_FULL_PATH = ROOT_PATH + "/src/main/resources/static/uploadFiles/images/";

    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket-name}")
    private String bucketName;

    public UploadDTO imageUpload(MultipartFile multipartFile) {

        // 원본 파일 이름 추출
        String originalFilename = multipartFile.getOriginalFilename();

        // 로컬과 s3 에 저장할 경로 생성
        String savedFilename = UUID.randomUUID() + "." + extractExt(originalFilename);

        // 파일 생성
        File file = new File(LOCAL_FULL_PATH, savedFilename);

        // 로컬에 파일 저장
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            throw new RuntimeException("파일을 저장하는 동안 오류가 발생했습니다.");
        }

        // s3 에 저장
        amazonS3Client.putObject(new PutObjectRequest(bucketName, savedFilename, file).withCannedAcl(CannedAccessControlList.PublicRead));

        // s3 에 저장한 파일 url
        String s3Url = amazonS3Client.getUrl(bucketName, savedFilename).toString();

        // 로컬에 저장한 이미지 삭제
        file.delete();

        return UploadDTO.builder()
                .uploaded(true)
                .url(s3Url)
                .build();
    }

    private static String extractExt(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos +1);
    }
}
