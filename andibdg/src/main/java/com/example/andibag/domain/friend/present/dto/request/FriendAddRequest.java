package com.example.andibag.domain.friend.present.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class FriendAddRequest {
    @NotBlank(message = "전화번호 는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Size(min = 11, max = 11, message = "전화번호 는 11글자여야 합니다.")
    private String phoneNumber;
}
