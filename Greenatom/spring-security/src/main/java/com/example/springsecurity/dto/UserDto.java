package com.example.springsecurity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private String company;
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd:MM:yyyy HH:mm - EEEE")
    private LocalDateTime time;
}
