package com.vividswan.studymate.api;

import com.vividswan.studymate.dto.UserJoinDto;
import com.vividswan.studymate.model.User;
import com.vividswan.studymate.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @AfterEach
    public void tearDown() throws Exception{
        userRepository.deleteAll();
    }

    @Test
    public void joinTest() throws Exception{
        //given
        String username = "vividswan";
        String password = "1234";
        String email = "vividswan@naver.com";
        String nickname = "soohwan";
        UserJoinDto userJoinDto = UserJoinDto.builder()
                .username(username)
                .password(password)
                .email(email)
                .nickname(nickname)
                .build();

        String url = "http://localhost:"+port+"/api/joinProc";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url,userJoinDto,Long.class);

        //then
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<User> all = userRepository.findAll();
        Assertions.assertThat(all.get(0).getUsername()).isEqualTo(username);
        Assertions.assertThat(all.get(0).getEmail()).isEqualTo(email);
    }

}