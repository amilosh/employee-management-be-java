package com.amilosh.service.impl;

import com.amilosh.dto.EmployeeCreateDto;
import com.amilosh.entity.Employee;
import com.amilosh.repository.EmployeeRepo;
import com.amilosh.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee create(EmployeeCreateDto dto) {
        Employee employee = new Employee();
        employee.setName(dto.getName());
        return employeeRepo.save(employee);
    }
}
