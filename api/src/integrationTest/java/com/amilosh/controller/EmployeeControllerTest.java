package com.amilosh.controller;

import com.amilosh.AbstractIntegrationTest;
import com.amilosh.EmployeeManagementApplicationTest;
import com.amilosh.dto.EmployeeCreateDto;
import com.amilosh.dto.EmployeeDto;
import com.amilosh.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = {EmployeeManagementApplicationTest.class})
public class EmployeeControllerTest extends AbstractIntegrationTest {

    @Test
    public void testCreateEmployee() {
        EmployeeCreateDto dto = new EmployeeCreateDto("Alex");
        String url = "/employee";
        EmployeeDto employee = this.webTestClient
                .post().uri(url)
                .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(dto)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(EmployeeDto.class).returnResult().getResponseBody();
        assertEquals(1, employee.getId());
        assertEquals("Alex", employee.getName());
    }
}
