import com.fasterxml.jackson.databind.ObjectMapper;
import com.parameta.app.EmployeeApplication;
import com.parameta.app.dto.Employee;
import com.parameta.app.dto.EmployeeResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = EmployeeApplication.class)
@AutoConfigureMockMvc
public class EmployeeTests {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createEmployee() throws Exception {
        Employee employee = Data.createEmployee001();

        MvcResult employeeResult = mvc.perform(
                MockMvcRequestBuilders.post("/api/v1/employees/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.durationInCompany").exists())
                .andExpect(jsonPath("$.age").exists())
                .andReturn();

        EmployeeResponse response = objectMapper.readValue(employeeResult.getResponse().getContentAsString(), EmployeeResponse.class);

        assertEquals(employee.getDocumentNumber(), response.getDocumentNumber());

        assertEquals(calculatePeriod(employee.getBirthDate()).getYears(), response.getAge().getYears());
        assertEquals(calculatePeriod(employee.getBirthDate()).getMonths(), response.getAge().getMonths());
        assertEquals(calculatePeriod(employee.getBirthDate()).getDays(), response.getAge().getDays());

        assertEquals(calculatePeriod(employee.getJoiningDate()).getYears(), response.getDurationInCompany().getYears());
        assertEquals(calculatePeriod(employee.getJoiningDate()).getMonths(), response.getDurationInCompany().getMonths());
        assertEquals(calculatePeriod(employee.getJoiningDate()).getDays(), response.getDurationInCompany().getDays());
    }

    @Test
    void createEmployeeWithError() throws Exception {
        Employee employee = Data.createEmployee002();
        mvc.perform(
                MockMvcRequestBuilders.post("/api/v1/employees/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors").exists())
                .andExpect(jsonPath("$.errors[0]").value("The employee must be at least 18 years old"));
    }

    public static Period calculatePeriod(LocalDate date) {
        return Period.between(date, LocalDate.now());
    }
}
