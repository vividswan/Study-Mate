package com.vividswan.studymate.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class UserLoginDto {
    private String username;
    private String password;

    @Builder
    UserLoginDto(String username, String password){
        this.username = username;
        this.password = password;
    }
}
