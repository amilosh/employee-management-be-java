package com.amilosh.service;

import com.amilosh.dto.EmployeeCreateDto;
import com.amilosh.entity.Employee;

public interface EmployeeService {

    Employee create(EmployeeCreateDto dto);
}
