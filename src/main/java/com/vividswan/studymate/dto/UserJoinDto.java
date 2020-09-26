package com.vividswan.studymate.dto;

import com.vividswan.studymate.model.User;
import lombok.*;

@Data
@NoArgsConstructor
public class UserJoinDto {
    private String username;
    private String password;
    private String email;
    private String nickname;

    @Builder
    public UserJoinDto(String username, String password, String email, String nickname){
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
    }

    public User toEntity(){
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .nickname(nickname)
                .build();
    }
}
