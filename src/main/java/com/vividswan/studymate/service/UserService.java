package com.vividswan.studymate.service;

import com.vividswan.studymate.dto.UserJoinDto;
import com.vividswan.studymate.model.User;
import com.vividswan.studymate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void join(UserJoinDto userJoinDto) {
        userRepository.save(userJoinDto.toEntity());
    }
}
