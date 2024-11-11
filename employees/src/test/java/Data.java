import com.parameta.app.dto.Employee;

import java.time.LocalDate;

public class Data {

    public static Employee createEmployee001() {
        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setDocumentType("Passport");
        employee.setDocumentNumber("A1234567");
        employee.setBirthDate(LocalDate.parse("2003-05-12"));
        employee.setJoiningDate(LocalDate.parse("2020-09-01"));
        employee.setPosition("Software Engineer");
        employee.setSalary(7500.0);
        return employee;
    }

    public static Employee createEmployee002() {
        Employee employee = new Employee();
        employee.setFirstName("Jane");
        employee.setLastName("Doe");
        employee.setDocumentType("CC");
        employee.setDocumentNumber("A12334567");
        employee.setBirthDate(LocalDate.parse("2008-05-12"));
        employee.setJoiningDate(LocalDate.parse("2020-09-01"));
        employee.setPosition("Data Scientist");
        employee.setSalary(5500.0);
        return employee;
    }


}
