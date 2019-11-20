package com.glookast.commons.capture.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class IngestReportTableModelDTOTest {

    @Test
    void deserializeJSON() throws IOException {

        String json = "{\n" +
            "  \"captureJobId\": \"02a4dc6a-0dd6-42ca-a2f5-537228c3470a\",\n" +
            " \"capturedClipName\" : \"clipname\",\n" +
            "  \"outputSystemList\": [\n" +
            "    \"New Output System (2019-11-05 10.03.23.995)\"\n" +
            "  ],\n" +
            "  \"records\": [\n" +
            "    {\n" +
            "      \"codecName\": \"AVCHD_LGOP_50\",\n" +
            "      \"outputSystemTypeName\": \"Generic Storage\",\n" +
            "      \"outputSystemName\": \"New Output System (2019-11-05 10.03.23.995)\",\n" +
            "      \"progress\": 25,\n" +
            "      \"state\": \"Failed\",\n" +
            "      \"statusMessage\": \"this is a status message\",\n" +
            "      \"reIngestJobPossible\": true,\n" +
            "      \"reCheckInJobPossible\": true,\n" +
            "      \"replaceOutputSystemPossible\": true\n" +
            "    }\n" +
            "  ],\n" +
            "  \"abortWorkflowPossible\": true,\n" +
            "  \"retryWorkflowPossible\": true,\n" +
            "  \"pauseWorkflowPossible\": true,\n" +
            "  \"resumeWorkflowPossible\": true\n" +
            "}";

        ObjectMapper mapper = new ObjectMapper();

        IngestReportTableModelDTO dto = mapper.reader()
            .forType(IngestReportTableModelDTO.class).readValue(json);

        assertNotNull(dto);
        assertEquals("clipname", dto.getCapturedClipName());
        assertEquals(UUID.fromString("02a4dc6a-0dd6-42ca-a2f5-537228c3470a"), dto.getCaptureJobId());

        assertEquals(1, dto.getRecords().size());
        final IngestReportTableRecordDTO recordDTO = dto.getRecords().get(0);
        assertNotNull(recordDTO);
        assertEquals("AVCHD_LGOP_50", recordDTO.getCodecName());
        assertEquals("Generic Storage", recordDTO.getOutputSystemTypeName());
        assertEquals("New Output System (2019-11-05 10.03.23.995)", recordDTO.getOutputSystemName());
        assertEquals(25, recordDTO.getProgress());
        assertEquals("Failed", recordDTO.getState());
        assertEquals("this is a status message", recordDTO.getStatusMessage());
        assertTrue(recordDTO.isReIngestJobPossible());
        assertTrue(recordDTO.isReCheckInJobPossible());
        assertTrue(recordDTO.isReplaceOutputSystemPossible());

        assertEquals(1, dto.getOutputSystemList().size());
        assertEquals("New Output System (2019-11-05 10.03.23.995)", dto.getOutputSystemList().get(0));

        assertTrue(dto.isAbortWorkflowPossible());
        assertTrue(dto.isPauseWorkflowPossible());
        assertTrue(dto.isResumeWorkflowPossible());
        assertTrue(dto.isRetryWorkflowPossible());

    }

    @Test
    void builder() {

        final String clipname = "clipname";
        final UUID captureJobId = UUID.randomUUID();

        IngestReportTableModelDTO dto = IngestReportTableModelDTO.builder()
            .captureJobId(captureJobId)
            .capturedClipName(clipname)
            .records(Collections.emptyList())
            .outputSystemList(Collections.emptyList())
            .abortWorkflowPossible(true)
            .pauseWorkflowPossible(true)
            .resumeWorkflowPossible(true)
            .retryWorkflowPossible(true)
            .build();

        assertNotNull(dto);
        assertEquals(clipname, dto.getCapturedClipName());
        assertEquals(captureJobId, dto.getCaptureJobId());
        assertEquals(0, dto.getRecords().size());
        assertEquals(0, dto.getOutputSystemList().size());
        assertTrue(dto.isAbortWorkflowPossible());
        assertTrue(dto.isPauseWorkflowPossible());
        assertTrue(dto.isResumeWorkflowPossible());
        assertTrue(dto.isRetryWorkflowPossible());

    }

}