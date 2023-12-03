package com.example.cookeryket_sb.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.io.PrintWriter;

@RestControllerAdvice
public class CookeryketExceptionHandler {


    @ExceptionHandler(CookeryketException.class)
    public String handlingException(CookeryketException exception, HttpServletResponse response) throws IOException {
        String message = exception.getMessage();
        response.setStatus(400);
        return message;
    }
}