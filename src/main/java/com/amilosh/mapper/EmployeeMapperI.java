package com.amilosh.mapper;

import com.amilosh.dto.EmployeeCreateDto;
import com.amilosh.dto.EmployeeDto;
import com.amilosh.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapperI {

    Employee toEntity(EmployeeCreateDto dto);

    EmployeeDto toDto(Employee employee);
}
