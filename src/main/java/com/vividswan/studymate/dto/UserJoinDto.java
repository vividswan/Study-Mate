package com.vividswan.studymate.dto;

import com.vividswan.studymate.model.RoleType;
import com.vividswan.studymate.model.User;
import lombok.*;

@Data
@NoArgsConstructor
public class UserJoinDto {
    private String username;
    private String password;
    private String email;
    private String nickname;
    private RoleType role;

    @Builder
    public UserJoinDto(String username, String password, String email, String nickname, RoleType role){
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.role = role;
    }

    public User toEntity(){
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .nickname(nickname)
                .role(role)
                .build();
    }
}
