package com.example.testing.techspec.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExceptionDto {

    private String message;

    private LocalDateTime timeStamp;
}
