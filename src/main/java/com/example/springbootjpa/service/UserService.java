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


    public ResponseDto Userget(Long id){
        Optional<User> optUser = userRepository.findById(id);
        if(optUser.isEmpty()){
            return new ResponseDto(id, "", "해당 id 유저가 없습니다.");
        } else {
            User user = optUser.get();
            return new ResponseDto (user.getId(), user.getUsername(), "");

        }
    }


//    public void Useradd(RequestDto requestDto) {
//        User user = requestDto.toUser();
//        User saveUser = userRepository.save(user);
//    }

}