package com.parameta.app.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Period;

public class PeriodDeserializer extends JsonDeserializer<Period> {

    @Override
    public Period deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String periodString = p.getText();
        String[] parts = periodString.split(" ");

        int years = Integer.parseInt(parts[0]);
        int months = Integer.parseInt(parts[2]);
        int days = Integer.parseInt(parts[4]);

        return Period.of(years, months, days);
    }
}