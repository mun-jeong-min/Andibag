package com.example.andibag.domain.comment.present.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class CommentCreateRequest {

    @NotBlank(message = "content가 비어있습니다.")
    @Size(min = 1, max = 150)
    private String content;
}
