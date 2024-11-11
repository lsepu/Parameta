package com.parameta.app.services;


import com.parameta.app.dto.EmployeeRequest;
import com.parameta.app.model.Employee;
import com.parameta.app.repositories.EmployeeRepository;
import com.parameta.app.utils.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    public void saveEmployee(EmployeeRequest request) {
        Employee employee = employeeMapper.EmployeeRequestToEmployee(request);
        employeeRepository.save(employee);
    }

}
