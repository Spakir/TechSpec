package com.example.testing.techspec.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    private String username;

    private LocalDateTime registeredAt;

    private LocalDate birthDate;

    private List<SubscribeDto> subscribes = new ArrayList<>();
}
