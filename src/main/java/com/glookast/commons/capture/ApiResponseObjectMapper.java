package com.glookast.commons.capture;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ApiResponseObjectMapper {

    private static ObjectMapper mapper;

    public static ObjectMapper getMapper() {

        if (mapper == null) {
            mapper = new ObjectMapper();
            mapper.registerModule(new Jdk8Module());
            mapper.registerModule(new JavaTimeModule());
            mapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        }
        return mapper;

    }

}
