package com.example.springbootjpa.controller;

import com.example.springbootjpa.dto.ResponseDto;
import com.example.springbootjpa.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Test
    @DisplayName("입력한 ID로 조회 성공 했을 경우 massage 잘 나오는지")
     void findByid () throws Exception {

        given(userService.Userget(1l))
                .willReturn(new ResponseDto(1l, "subin", "회원 등록 성공"));

        mockMvc.perform(get("/api/v1/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.message").value("회원 등록 성공"))
                .andDo(print());
    }



    @Test
    @DisplayName("입력한 ID로 조회 실패 했을 경우 massage 잘 나오는지")
    void findByidfail () throws Exception {

        given(userService.Userget(11l))
                .willReturn(new ResponseDto("해당 id user 가 없습니다."));

        mockMvc.perform(get("/api/v1/users/11"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isEmpty())
                .andExpect(jsonPath("$.message").value("해당 id user 가 없습니다."))
                .andDo(print());
    }

}

