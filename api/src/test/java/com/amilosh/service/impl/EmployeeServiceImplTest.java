package com.amilosh.service.impl;

import com.amilosh.dto.EmployeeCreateDto;
import com.amilosh.entity.Employee;
import com.amilosh.mapper.EmployeeMapper;
import com.amilosh.repository.EmployeeRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepo employeeRepo;

    @Mock
    private EmployeeMapper employeeMapper;

    @InjectMocks
    private EmployeeServiceImpl service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createTest() {
        EmployeeCreateDto dto = new EmployeeCreateDto("Alex");
        Employee employee = new Employee(null, "Alex");
        when(employeeMapper.toEntity(dto)).thenReturn(employee);
        Employee savedEmployee = new Employee(1, "Alex");
        when(employeeRepo.save(employee)).thenReturn(savedEmployee);
        Employee result = service.create(dto);
        assertEquals(1, result.getId());
        assertEquals("Alex", result.getName());
    }
}
