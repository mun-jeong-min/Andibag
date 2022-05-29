package com.example.andibag.domain.notice.present.dto.reqeust;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class NoticeCreateRequest {

    @NotBlank(message = "title은 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Size(min = 1, max = 20, message = "title은 20글자이상을 허용하지 않습니다.")
    private String title;

    @NotBlank(message = "content는 Null을 허용하지 않습니다")
    private String content;
}
