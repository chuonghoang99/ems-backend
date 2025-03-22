package com.chuong.emsbackend.dto;

import lombok.*;

@Builder
public record EmployeeDto(Long id, String name, String email) {}
