package com.parameta.app.controller;


import com.parameta.app.dto.EmployeeRequest;
import com.parameta.app.dto.EmployeeResponse;
import com.parameta.app.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EmployeeController {
    private static final String NAMESPACE_URI = "http://www.example.com/employee";

    @Autowired
    private EmployeeService employeeService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "EmployeeRequest")
    @ResponsePayload
    public EmployeeResponse saveEmployee(@RequestPayload EmployeeRequest request) {

        employeeService.saveEmployee(request);

        EmployeeResponse response = new EmployeeResponse();
        response.setStatus("Success");
        return response;
    }
}
