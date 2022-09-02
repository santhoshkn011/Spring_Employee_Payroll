package com.example.springemployeepayroll.exception;


import com.example.springemployeepayroll.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
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
    //For Invalid Date Format error
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDto> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException exception) {
        log.error("Invalid Date Format", exception);
        ResponseDto resDTO = new ResponseDto("Exception while processing REST Request",
                "Date Should be in the Format of 'dd MM yyyy'");
        return new ResponseEntity(resDTO, HttpStatus.BAD_REQUEST);
    }
}
