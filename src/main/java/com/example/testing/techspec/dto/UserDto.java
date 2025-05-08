package com.example.testing.techspec.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "Имя пользователя не должно быть пустым")
    @Size(min = 3, max = 50, message = "Имя пользователя должно содержать от 3 до 50 символов")
    private String username;

    private LocalDateTime registeredAt;

    private LocalDate birthDate;

    private List<SubscribeDto> subscribes = new ArrayList<>();
}
