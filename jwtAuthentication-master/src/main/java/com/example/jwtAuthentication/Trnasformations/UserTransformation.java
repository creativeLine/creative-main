package com.example.jwtAuthentication.Trnasformations;

import com.example.jwtAuthentication.Dto.RequsetDto.UserRequestDto;
import com.example.jwtAuthentication.Models.User;

public class UserTransformation {

    public static User convertEntity(UserRequestDto userRequestDto){
        User user = User.builder()
                .gstNo(userRequestDto.getGstNo())
                .panCardNo(userRequestDto.getCompany())
                .password(userRequestDto.getPassword())
                .companyName(userRequestDto.getPanCardNo())
                .msmeId(userRequestDto.getMsmeId())
                .build();
        return user;
    }
}
