package com.example.testing.techspec.handler;

import com.example.testing.techspec.dto.ExceptionDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class, NoSuchElementException.class})
    public ResponseEntity<ExceptionDto> handleNotFoundException(Exception e) {
        ExceptionDto dto = new ExceptionDto(e.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handleGeneralException(Exception e) {
        ExceptionDto dto = new ExceptionDto(e.getMessage(), LocalDateTime.now());
        return ResponseEntity.internalServerError().body(dto);
    }
}
