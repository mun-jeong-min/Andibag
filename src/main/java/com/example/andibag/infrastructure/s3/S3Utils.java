package com.example.andibag.infrastructure.s3;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.andibag.global.exception.UploadFileException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class S3Utils {
    private final S3Properties s3Properties;
    private final AmazonS3Client amazonS3Client;

    public String upload(MultipartFile file) {
        String uploadFile = s3Properties.getBucket() + "/" + UUID.randomUUID() + file.getOriginalFilename();

        try {
            amazonS3Client.putObject(new PutObjectRequest(s3Properties.getBucket(), uploadFile, file.getInputStream(), null)
                    .withCannedAcl(CannedAccessControlList.AuthenticatedRead));
        } catch (Exception e) {
            throw UploadFileException.EXCEPTION;
        }
        return amazonS3Client.getUrl(s3Properties.getBucket(), uploadFile).toString();
    }
}
