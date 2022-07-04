package com.example.andibag.domain.image.service;

import com.example.andibag.domain.image.present.dto.ImageResponse;
import com.example.andibag.infrastructure.s3.S3Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ImageService {
    private final S3Utils s3Utils;

    @Transactional(readOnly = true)
    public ImageResponse queryImage(List<MultipartFile> file)  {
        List<String> image = file.stream()
                .map(s3Utils::upload)
                .collect(Collectors.toList());

        return ImageResponse.builder()
                .image(image)
                .build();
    }
}
