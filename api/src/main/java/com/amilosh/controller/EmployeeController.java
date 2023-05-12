package com.amilosh.controller;

import com.amilosh.controller.api.EmployeeControllerApi;
import com.amilosh.dto.EmployeeCreateDto;
import com.amilosh.dto.EmployeeDto;
import com.amilosh.entity.Employee;
import com.amilosh.mapper.EmployeeMapper;
import com.amilosh.service.EmployeeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController implements EmployeeControllerApi {

    @Value("${valueFromApplicationProperties}")
    private String valueFromApplicationProperties;

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    public EmployeeController(EmployeeService employeeService, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto createEmployee(@RequestBody EmployeeCreateDto dto) {
        Employee employee = employeeService.create(dto);
        return employeeMapper.toDto(employee);
    }

    @GetMapping()
    public String getProperty() {
        return valueFromApplicationProperties;
    }
}
