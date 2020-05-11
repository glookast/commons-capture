package com.glookast.commons.capture;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.TimeUnit;


public class ApiErrorTest {

    ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        mapper.registerModule(new Jdk8Module());
        mapper.registerModule(new JavaTimeModule());
        mapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    @Test
    public void toJSON() throws JsonProcessingException {

        ApiError error = ApiError.builder()
                .timestamp(OffsetDateTime.now())
                .status(500)
                .error("ERROR")
                .method("POST")
                .path("PATH")
                .build();
        String json = mapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(error);

        Assertions.assertNotNull(json);

    }

    @Test
    public void convertToString() {

        ApiError error = ApiError.builder()
                .timestamp(OffsetDateTime.now())
                .status(500)
                .error("ERROR")
                .method("POST")
                .path("PATH")
                .build();
        String str = error.toString();

        Assertions.assertNotNull(str);

    }

    @Test
    public void parseApiErrorFromEmptyJSON() throws IOException {

        String json = "{}";

        ApiError apiError = mapper.readValue(json, ApiError.class);
        Assertions.assertNotNull(apiError);
        Assertions.assertNotNull(apiError.timestamp);

    }

    @Test
    public void parseApiErrorFromJSON() throws IOException {

        String json = "{\n" +
                "  \"@type\": \"ApiError\",\n" +
                "  \"timestamp\": \"2020-05-08T17:20:13.141+01:00\",\n" +
                "  \"status\": 400,\n" +
                "  \"error\": \"Bad Request\",\n" +
                "  \"message\": \"Invalid gang configuration\",\n" +
                "  \"detail\": \"Channel is already part of a gang, remove it first!\",\n" +
                "  \"path\": \"/api/v1/gang-control/\"\n" +
                "}";

        ApiError apiError = mapper.readValue(json, ApiError.class);

        Assertions.assertNotNull(apiError);
        Assertions.assertEquals(OffsetDateTime.of(
                2020,
                5,
                8,
                16,
                20,
                13,
                Math.toIntExact(TimeUnit.NANOSECONDS.convert(141, TimeUnit.MILLISECONDS)),
                ZoneOffset.of("Z")
        ), apiError.timestamp);
        Assertions.assertEquals(400, apiError.status);
        Assertions.assertEquals("Bad Request", apiError.error);
        Assertions.assertEquals("Invalid gang configuration", apiError.message);
        Assertions.assertEquals("Channel is already part of a gang, remove it first!", apiError.detail);
        Assertions.assertEquals("/api/v1/gang-control/", apiError.path);
        Assertions.assertNull(apiError.method);

    }

    @Test
    public void builder() {

        OffsetDateTime timestamp = OffsetDateTime.now();
        int status = 400;
        String error = "error";
        String message = "message";
        String detail = "detail";
        String path = "path";
        String method = "method";

        ApiError apiError = ApiError.builder()
                .timestamp(timestamp)
                .status(status)
                .error(error)
                .message(message)
                .detail(detail)
                .path(path)
                .method(method)
                .build();

        Assertions.assertNotNull(apiError);
        Assertions.assertEquals(timestamp, apiError.timestamp);
        Assertions.assertEquals(status, apiError.status);
        Assertions.assertEquals(error, apiError.error);
        Assertions.assertEquals(message, apiError.message);
        Assertions.assertEquals(detail, apiError.detail);
        Assertions.assertEquals(path, apiError.path);
        Assertions.assertEquals(method, apiError.method);

    }

    @Test
    public void builderTimestampDefault() {

        ApiError apiError = ApiError.builder()
                .status(500)
                .error("ERROR")
                .method("POST")
                .path("PATH")
                .build();
        Assertions.assertNotNull(apiError);
        Assertions.assertNotNull(apiError.timestamp);

    }

}