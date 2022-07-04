package com.example.andibag.domain.image.present;

import com.example.andibag.domain.image.present.dto.ImageResponse;
import com.example.andibag.domain.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/image")
public class ImageController {
    private final ImageService imageService;

    @PostMapping
    public ImageResponse saveImage(@RequestPart List<MultipartFile> file) {
        return imageService.queryImage(file);
    }
}
