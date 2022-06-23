package com.example.andibag.domain.reply.present.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class ReplyCreateRequest {
    @Size(min = 1, max = 150)
    private String content;
}
