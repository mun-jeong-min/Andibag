package com.example.andibag.domain.comment.present.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class CommentUpdateRequest {

    @NotBlank(message = "content가 비어있습니다.")
    private String content;
}
