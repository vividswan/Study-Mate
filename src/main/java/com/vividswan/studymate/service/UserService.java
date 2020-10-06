package com.vividswan.studymate.service;

import com.vividswan.studymate.dto.UserJoinDto;
import com.vividswan.studymate.dto.UserUpdateDto;
import com.vividswan.studymate.model.RoleType;
import com.vividswan.studymate.model.User;
import com.vividswan.studymate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserRepository userRepository;

    @Transactional
    public boolean join(UserJoinDto userJoinDto) {
        User findUser = userRepository.findByUsername(userJoinDto.getUsername()).orElseGet(()->
            null);
        System.out.println(findUser);
        if(findUser!=null) return false;
        String rawPassword = userJoinDto.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        userJoinDto.setPassword(encPassword);
        userJoinDto.setRole(RoleType.USER);
        userRepository.save(userJoinDto.toEntity());
        return true;
    }

    @Transactional
    public void update(Long userId, UserUpdateDto userUpdateDto) {
        User  findUser = userRepository.findById(userId).orElseThrow(()->{
            return new IllegalArgumentException("해당 유저를 찾을 수 없습니다.");
        });
        String rawPassword = userUpdateDto.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        findUser.update(encPassword, userUpdateDto.getNickname(),userUpdateDto.getEmail());
    }
}
