package com.parameta.app.dto;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.parameta.app.serializer.PeriodDeserializer;
import com.parameta.app.serializer.PeriodSerializer;
import lombok.Data;

import java.time.Period;

@Data
public class EmployeeResponse extends Employee {

    @JsonSerialize(using = PeriodSerializer.class)
    @JsonDeserialize(using = PeriodDeserializer.class)
    private Period durationInCompany;

    @JsonSerialize(using = PeriodSerializer.class)
    @JsonDeserialize(using = PeriodDeserializer.class)
    private Period age;

}
