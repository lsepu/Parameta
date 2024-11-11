package com.parameta.app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.parameta.app.validator.Adult;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Employee {

    @NotEmpty(message = "firstName can't be empty")
    private String firstName;

    @NotEmpty(message = "lastName can't be empty")
    private String lastName;

    @NotEmpty(message = "documentType can't be empty")
    private String documentType;

    @NotEmpty(message = "documentNumber can't be empty")
    private String documentNumber;

    @NotNull(message = "birthDate can't be empty")
    @Adult
    @JsonFormat(shape = JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate birthDate;

    @NotNull(message = "joiningDate can't be empty")
    @JsonFormat(shape = JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate joiningDate;

    @NotEmpty(message = "position can't be empty")
    private String position;

    @NotNull(message = "salary can't be empty")
    @Positive(message = "Salary must be greater than zero")
    private Double salary;
}
