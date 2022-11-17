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
    private String message;

    public ResponseDto(String message) {
        this.message = message;
    }
}
