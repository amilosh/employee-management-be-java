package com.amilosh.service.impl;

import com.amilosh.dto.EmployeeCreateDto;
import com.amilosh.entity.Employee;
import com.amilosh.mapper.EmployeeMapper;
import com.amilosh.repository.EmployeeRepo;
import com.amilosh.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo, EmployeeMapper employeeMapper) {
        this.employeeRepo = employeeRepo;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public Employee create(EmployeeCreateDto dto) {
        Employee employee = employeeMapper.toEntity(dto);
        return employeeRepo.save(employee);
    }
}
