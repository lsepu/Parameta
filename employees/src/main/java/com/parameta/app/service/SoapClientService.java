package com.parameta.app.service;

import com.parameta.app.dto.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SoapClientService {

    private final SoapClient soapClient;

    public void saveEmployee(Employee employee) {
        String soapRequest = employeeToSoapRequest(employee);
        soapClient.saveEmployee(soapRequest);
    }

    private String employeeToSoapRequest(Employee employee) {
        StringBuilder soapRequestBuilder = new StringBuilder();
        soapRequestBuilder.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" ");
        soapRequestBuilder.append("xmlns:emp=\"http://www.example.com/employee\">");
        soapRequestBuilder.append("<soapenv:Header/>");
        soapRequestBuilder.append("<soapenv:Body>");
        soapRequestBuilder.append("<emp:EmployeeRequest>");

        // Datos del empleado
        soapRequestBuilder.append("<firstName>").append(employee.getFirstName()).append("</firstName>");
        soapRequestBuilder.append("<lastName>").append(employee.getLastName()).append("</lastName>");
        soapRequestBuilder.append("<documentType>").append(employee.getDocumentType()).append("</documentType>");
        soapRequestBuilder.append("<documentNumber>").append(employee.getDocumentNumber()).append("</documentNumber>");
        soapRequestBuilder.append("<birthDate>").append(employee.getBirthDate()).append("</birthDate>");
        soapRequestBuilder.append("<joiningDate>").append(employee.getJoiningDate()).append("</joiningDate>");
        soapRequestBuilder.append("<position>").append(employee.getPosition()).append("</position>");
        soapRequestBuilder.append("<salary>").append(employee.getSalary()).append("</salary>");

        soapRequestBuilder.append("</emp:EmployeeRequest>");
        soapRequestBuilder.append("</soapenv:Body>");
        soapRequestBuilder.append("</soapenv:Envelope>");

        return soapRequestBuilder.toString();
    }
}