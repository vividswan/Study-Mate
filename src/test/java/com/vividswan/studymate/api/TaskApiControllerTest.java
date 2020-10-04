package com.vividswan.studymate.api;

import com.vividswan.studymate.dto.TaskWriteDto;
import com.vividswan.studymate.model.Task;
import com.vividswan.studymate.repository.TaskRepository;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TaskApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    TestRestTemplate restTemplate;

    @AfterEach
    public void tearDown(){
        taskRepository.deleteAll();
    }

    @Test
    public void writeTest() throws Exception{
        //given
        String title ="Test Title";
        String content = "<h1>Hello World</h1>";
        LocalDateTime deadline = LocalDateTime.of(2020,1,21,0,0,0);
        TaskWriteDto taskWriteDto = TaskWriteDto.builder()
                .title(title)
                .content(content)
                .deadline(deadline)
                .build();

        String url = "http://localhost:"+port+"/api/writeProc";


        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url,taskWriteDto,Long.class);

        //then
        List<Task> list = taskRepository.findAll();
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseEntity.getBody()).isGreaterThan(0L);
        Assertions.assertThat(list.get(0).getTitle()).isEqualTo(title);
        Assertions.assertThat(list.get(0).getContent()).isEqualTo(content);
        Assertions.assertThat(list.get(0).getDeadline()).isEqualTo(deadline);
    }

}