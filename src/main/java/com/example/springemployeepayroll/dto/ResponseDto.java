package com.example.springemployeepayroll.dto;

import com.example.springemployeepayroll.model.EmployeeEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDto {
    String message;
    Object response;
    public ResponseDto(String message, EmployeeEntity response) {
        this.message = message;
        this.response = response;
    }
}
