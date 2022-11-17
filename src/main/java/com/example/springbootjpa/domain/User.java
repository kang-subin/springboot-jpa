package com.example.springbootjpa.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "User")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String username;
    private String password;


}
