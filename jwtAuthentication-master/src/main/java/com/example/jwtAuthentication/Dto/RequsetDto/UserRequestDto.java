package com.example.jwtAuthentication.Dto.RequsetDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    private String gstNo;
    private String company;
    private String password;
    private String panCardNo;
    private String msmeId;
    //we can add other field as we want
}
