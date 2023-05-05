package com.amilosh.mapper;

import com.amilosh.dto.EmployeeCreateDto;
import com.amilosh.dto.EmployeeDto;
import com.amilosh.entity.Employee;
import com.amilosh.entity.enumeration.EmployeeDivision;
import com.amilosh.entity.enumeration.EmployeeType;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.ValueMapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class EmployeeMapper {

    public abstract Employee toEntity(EmployeeCreateDto dto);

    public abstract EmployeeDto toDto(Employee employee);

    // enum to enum
    @ValueMapping(source = "JAVA_DEVELOPER", target = "PRODUCTION")
    @ValueMapping(source = "JAVA_SCRIPT_DEVELOPER", target = "PRODUCTION")
    @ValueMapping(source = "RESOURCE_MANAGER", target = "ADMINISTRATIVE")
    @ValueMapping(source = "FINANCE_MANAGER", target = "ADMINISTRATIVE")
    public abstract EmployeeDivision toEmployeeDivision(EmployeeType employeeType);
}
