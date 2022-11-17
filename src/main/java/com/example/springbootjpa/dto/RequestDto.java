package com.example.springbootjpa.dto;

import com.example.springbootjpa.domain.User;
import com.example.springbootjpa.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {

    private String username;
    private String password;

    public User toUser (){
            return User.builder()
                    .username(this.username)
                    .password(this.password)
                    .build();
        }
}
