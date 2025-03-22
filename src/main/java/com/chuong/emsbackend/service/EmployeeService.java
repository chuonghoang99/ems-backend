package com.chuong.emsbackend.service;

import com.chuong.emsbackend.dto.EmployeeDto;
import com.chuong.emsbackend.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);

    List<EmployeeDto> getAllEmployees();
}
