package com.parameta.app.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.parameta.app.dto.Employee;
import com.parameta.app.dto.EmployeeResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component
public class EmployeeMapper {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public EmployeeResponse employeeToEmployeeResponse(Employee employee){
        EmployeeResponse employeeResponse = objectMapper.convertValue(employee, EmployeeResponse.class);
        employeeResponse.setAge(calculatePeriod(employeeResponse.getBirthDate()));
        employeeResponse.setDurationInCompany(calculatePeriod(employeeResponse.getJoiningDate()));
        return employeeResponse;
    }

    private Period calculatePeriod(LocalDate date){
        return Period.between(date, LocalDate.now());
    }

}
