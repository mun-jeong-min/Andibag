package com.example.andibag.infrastructure.s3;

import org.springframework.web.multipart.MultipartFile;

public interface ImageUtil {
    String upload(MultipartFile file);
}
