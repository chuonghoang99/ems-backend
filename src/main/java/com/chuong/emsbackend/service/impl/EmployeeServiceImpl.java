package com.chuong.emsbackend.service.impl;

import com.chuong.emsbackend.config.locale.Translator;
import com.chuong.emsbackend.dto.EmployeeDto;
import com.chuong.emsbackend.entity.Employee;
import com.chuong.emsbackend.exception.ResourceNotFoundEx;
import com.chuong.emsbackend.mapper.EmployeeMapper;
import com.chuong.emsbackend.repository.EmployeeRepository;
import com.chuong.emsbackend.service.EmployeeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(@RequestBody EmployeeDto employeeDto) {
        var employee = EmployeeMapper.mapToEmployee(employeeDto);

        return employeeRepository.save(employee);

    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        var employee =
                employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundEx(Translator.toLocale("user.notFound")));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees
                .stream()
                .map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

}



