package com.amilosh.controller.api;

import com.amilosh.dto.EmployeeCreateDto;
import com.amilosh.dto.EmployeeDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = {"Employee API"})
public interface EmployeeControllerApi {

    @ApiOperation(value = "Create Employee.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Employee was created successfully.")
    })
    EmployeeDto createEmployee(EmployeeCreateDto dto);
}
