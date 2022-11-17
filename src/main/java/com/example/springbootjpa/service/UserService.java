package com.example.springbootjpa.service;

import com.example.springbootjpa.domain.User;
import com.example.springbootjpa.dto.RequestDto;
import com.example.springbootjpa.dto.ResponseDto;
import com.example.springbootjpa.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public ResponseDto Userget(Long id) {
        Optional<User> optUser = userRepository.findById(id);
        if (optUser.isEmpty()) {
            return new ResponseDto(id, "", "해당 id 유저가 없습니다.");
        } else {
            User user = optUser.get();
            return new ResponseDto(user.getId(), user.getUsername(), "");

        }
    }

    public ResponseDto Useradd(RequestDto requestDto) {
        Optional<User> seleteUser = userRepository.findByUsername(requestDto.getUsername());
        User user = requestDto.toUser();
        if (seleteUser.isEmpty()) {
            User saveUser = userRepository.save(user);
            return new ResponseDto(saveUser.getId(), saveUser.getUsername(), "회원 등록 성공");
        } else {
            return new ResponseDto("이 user는 이미 존재 합니다. 다른 이름을 사용하세요");
        }
    }
}