package com.example.springemployeepayroll.dto;

import com.example.springemployeepayroll.model.EmployeeEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
public class ResponseDto {
    String message;
    Object response;
    public ResponseDto(String message, Optional<EmployeeEntity> response) {
        this.message = message;
        this.response = response;
    }
    public ResponseDto(String message, List<EmployeeEntity> response) {
        this.message = message;
        this.response = response;
    }
    public ResponseDto(String message, String response) {
        this.message = message;
        this.response = response;
    }
}
