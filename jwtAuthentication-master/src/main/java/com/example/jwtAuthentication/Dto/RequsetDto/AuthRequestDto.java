package com.example.jwtAuthentication.Dto.RequsetDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequestDto {

    private String gstNo;
    private String password;

}
