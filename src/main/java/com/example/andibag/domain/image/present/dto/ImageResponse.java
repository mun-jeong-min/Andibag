package com.example.andibag.domain.image.present.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ImageResponse {
    private final List<String> image;
}
