package net.javaguides.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class EmployeeNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String >exceptionHandlet(ResourceNotFoundException exception){
        Map<String,String>errorMap=new HashMap<>();
        errorMap.put("errorMessage",exception.getMessage());
        return  errorMap;
    }
}
