package com.parameta.app.service;

import com.parameta.app.dto.Employee;
import com.parameta.app.dto.EmployeeResponse;
import com.parameta.app.utils.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeMapper employeeMapper;
    private final SoapClientService soapClientService;

    public EmployeeResponse getEmployeeInformation(Employee employee) {
        soapClientService.saveEmployee(employee);
        EmployeeResponse response = employeeMapper.employeeToEmployeeResponse(employee);
        return response;
    }

}
