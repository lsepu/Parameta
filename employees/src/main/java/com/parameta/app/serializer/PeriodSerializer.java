package com.parameta.app.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.Period;

public class PeriodSerializer extends JsonSerializer<Period> {

    @Override
    public void serialize(Period value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        String formatted = String.format("%d years, %d months, %d days",
                value.getYears(), value.getMonths(), value.getDays());
        gen.writeString(formatted);
    }
}
