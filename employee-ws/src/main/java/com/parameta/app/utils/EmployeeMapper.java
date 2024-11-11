package com.parameta.app.utils;

import com.parameta.app.dto.EmployeeRequest;
import com.parameta.app.model.Employee;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EmployeeMapper {

    public Employee EmployeeRequestToEmployee(EmployeeRequest employeeRequest){
        Employee employee = new Employee();
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setDocumentType(employeeRequest.getDocumentType());
        employee.setDocumentNumber(employeeRequest.getDocumentNumber());
        employee.setBirthDate(LocalDate.parse(employeeRequest.getBirthDate()));
        employee.setJoiningDate(LocalDate.parse(employeeRequest.getJoiningDate()));
        employee.setPosition(employeeRequest.getPosition());
        employee.setSalary(employeeRequest.getSalary());

        return employee;
    }

}
