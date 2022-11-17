package com.example.springbootjpa.controller;

import com.example.springbootjpa.dto.RequestDto;
import com.example.springbootjpa.dto.ResponseDto;
import com.example.springbootjpa.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public void useradd (@RequestBody RequestDto requestDto){

    }


    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getUser (@PathVariable Long id){
        return ResponseEntity.ok().body(userService.Userget(id));
    }

}
