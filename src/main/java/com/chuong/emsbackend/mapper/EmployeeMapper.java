package com.chuong.emsbackend.mapper;

import com.chuong.emsbackend.dto.EmployeeDto;
import com.chuong.emsbackend.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .email(employee.getEmail())
                .build();
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {

        return new Employee(employeeDto.id(), employeeDto.name(),
                employeeDto.email());
    }
}
