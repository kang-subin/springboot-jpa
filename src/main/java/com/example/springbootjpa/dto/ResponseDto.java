package com.example.springbootjpa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {

    private Long id;
    private String username;
    private String message; // password 가 아니라 massage임

}
