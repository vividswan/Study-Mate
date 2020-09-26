package com.vividswan.studymate.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserJoinDtoTest {

    @Test
    public void dtoBuilderTest(){
        UserJoinDto userJoinDto = UserJoinDto.builder()
                .username("vividswan")
                .password("1234")
                .email("vividswan@naver.com")
                .nickname("soohwan")
                .build();
        Assertions.assertThat(userJoinDto.getUsername()).isEqualTo("vividswan");
        Assertions.assertThat(userJoinDto.getPassword()).isEqualTo("1234");
        Assertions.assertThat(userJoinDto.getEmail()).isEqualTo("vividswan@naver.com");
        Assertions.assertThat(userJoinDto.getNickname()).isEqualTo("soohwan");
    }
}