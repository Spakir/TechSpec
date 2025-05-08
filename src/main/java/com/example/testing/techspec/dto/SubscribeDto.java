package com.example.testing.techspec.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SubscribeDto {

    @NotNull(message = "Тип сервиса не должен быть null")
    private String serviceType;

    private Long userId;

    @NotNull(message = "Начало подписки не должно быть null")
    private LocalDate startDate;

    @NotNull(message = "Конец подписки не должен быть null")
    private LocalDate endDate;
}
