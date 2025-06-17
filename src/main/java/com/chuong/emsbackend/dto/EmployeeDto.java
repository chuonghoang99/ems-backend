package com.chuong.emsbackend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
public record EmployeeDto(
        Long id,

        @Size(min = 2, max = 50, message = "{employee.size.invalid}")
        String name,

        @Email(message = "{employee.email.invalid}")
        String email
) {}
