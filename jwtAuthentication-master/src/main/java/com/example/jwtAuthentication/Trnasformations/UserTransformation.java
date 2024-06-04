package com.example.jwtAuthentication.Trnasformations;

import com.example.jwtAuthentication.Dto.RequsetDto.UserRequestDto;
import com.example.jwtAuthentication.Models.User;

public class UserTransformation {

    public static User convertEntity(UserRequestDto userRequestDto){
        User user = User.builder()
                .gstNo(userRequestDto.getUsername())
                .panCardNo(userRequestDto.getEmail())
                .password(userRequestDto.getPassword())
                .companyName(userRequestDto.getAge())
                .msmeId(userRequestDto.getGender())
                .build();
        return user;
    }
}
