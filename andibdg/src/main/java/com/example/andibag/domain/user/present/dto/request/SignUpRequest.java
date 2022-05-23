package com.example.andibag.domain.user.present.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class SignUpRequest {
    @NotBlank(message = "accountId는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Size(min = 8, max = 15, message = "accountId는 8자 이상, 15자 이하여야 합니다.")
    private String accountId;

    @NotBlank(message = "password는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    private String password;
    
    @NotBlank(message = "nickname은 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    private String nickname;

    @NotBlank(message = "전화번호 는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Size(min = 11, max = 11, message = "전화번호 는 11글자여야 합니다.")
    private String phoneNumber;
}
