package com.parameta.app.controller;

import com.parameta.app.dto.Employee;
import com.parameta.app.dto.EmployeeResponse;
import com.parameta.app.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<EmployeeResponse> addEmployee(@Valid @RequestBody Employee employee){
        EmployeeResponse response = employeeService.getEmployeeInformation(employee);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
