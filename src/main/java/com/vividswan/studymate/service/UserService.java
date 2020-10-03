package com.vividswan.studymate.service;

import com.vividswan.studymate.dto.UserJoinDto;
import com.vividswan.studymate.model.RoleType;
import com.vividswan.studymate.model.User;
import com.vividswan.studymate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserRepository userRepository;

    @Transactional
    public void join(UserJoinDto userJoinDto) {
        String rawPassword = userJoinDto.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        userJoinDto.setPassword(encPassword);
        userJoinDto.setRole(RoleType.USER);
        userRepository.save(userJoinDto.toEntity());
    }
}
