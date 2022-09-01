package com.example.springemployeepayroll.exception;


import com.example.springemployeepayroll.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class EmployeePayrollHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> error_message = errorList.stream()
                .map(objErr -> objErr.getDefaultMessage())
                .collect(Collectors.toList());
        ResponseDto resDTO = new ResponseDto("Exception while processing REST request", error_message.toString());
        return new ResponseEntity(resDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EmployeePayrollException.class)
    public ResponseEntity<ResponseDto> handleEmployeePayrollException(EmployeePayrollException exception){
        ResponseDto resDTO = new ResponseDto("Exception while processing REST request",
                exception.getMessage());
        return new ResponseEntity(resDTO, HttpStatus.BAD_REQUEST);
    }
}
