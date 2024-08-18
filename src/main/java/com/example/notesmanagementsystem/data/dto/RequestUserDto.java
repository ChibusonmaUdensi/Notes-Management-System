package com.example.notesmanagementsystem.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RequestUserDto {
    private String userName;
    private String email;
    private String password;

    private String userId;
}
