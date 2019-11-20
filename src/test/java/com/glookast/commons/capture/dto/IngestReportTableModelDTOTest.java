package com.glookast.commons.capture.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class IngestReportTableModelDTOTest {

    @Test
    void deserializeJSON() throws IOException {

        String json = "{\n" +
            "  \"captureJobId\": \"02a4dc6a-0dd6-42ca-a2f5-537228c3470a\",\n" +
            "  \"outputSystemList\": [\n" +
            "    \"New Output System (2019-11-05 10.03.23.995)\"\n" +
            "  ],\n" +
            "  \"records\": [\n" +
            "    {\n" +
            "      \"codecName\": \"AVCHD_LGOP_50\",\n" +
            "      \"outputSystemTypeName\": \"Generic Storage\",\n" +
            "      \"outputSystemName\": \"New Output System (2019-11-05 10.03.23.995)\",\n" +
            "      \"progress\": 0,\n" +
            "      \"state\": \"Failed\",\n" +
            "      \"statusMessage\": \"\",\n" +
            "      \"canReIngestJob\": true,\n" +
            "      \"canReCheckInJob\": true,\n" +
            "      \"canReplaceOutputSystem\": false\n" +
            "    }\n" +
            "  ],\n" +
            "  \"canAbortWorkflow\": false,\n" +
            "  \"canRetryWorkflow\": true,\n" +
            "  \"canPauseWorkflow\": false,\n" +
            "  \"canResumeWorkflow\": false\n" +
            "}";

        ObjectMapper mapper = new ObjectMapper();

        IngestReportTableModelDTO dto = mapper.reader()
            .forType(IngestReportTableModelDTO.class).readValue(json);

        assertNotNull(dto);

    }

}