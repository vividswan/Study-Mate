package com.vividswan.studymate.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserUpdateDto {
    private String password;
    private String email;
    private String nickname;

    @Builder
    public UserUpdateDto(String password, String email, String nickname){
        this.password = password;
        this.email = email;
        this.nickname = nickname;
    }
}
