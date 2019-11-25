package com.glookast.commons.capture.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.glookast.commons.capture.dto.templates.OutputSystem.OutputSystemDTO;
import com.glookast.commons.capture.dto.templates.OutputSystem.OutputSystemTypeDTO;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class IngestReportTableModelDTOTest {

    @Test
    void toJSON() throws IOException {

        IngestReportTableModelDTO dto = IngestReportTableModelDTO.builder()
            .captureJobId(UUID.randomUUID())
            .capturedClipName("clipName")
            .build();

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(dto);

        assertNotNull(json);

        // parse it and check it
        IngestReportTableModelDTO parsedDTO = mapper.reader()
            .forType(IngestReportTableModelDTO.class).readValue(json);

        assertNotNull(parsedDTO);
        assertEquals(dto.getCaptureJobId(), parsedDTO.getCaptureJobId());
        assertEquals(dto.getCapturedClipName(), parsedDTO.getCapturedClipName());

    }

    @Test
    void deserializeJSON() throws IOException {

        OutputSystemTypeDTO outputSystemTypeDTO = OutputSystemTypeDTO.builder()
            .id(1L)
            .systemType("System Type")
            .build();

        OutputSystemDTO outputSystemDTO = OutputSystemDTO.builder()
            .id(1L)
            .displayName("Output System")
            .type(outputSystemTypeDTO)
            .build();

        IngestReportTableRecordDTO recordDTO = IngestReportTableRecordDTO.builder()
            .codecName("AVCHD_LGOP_50")
            .outputSystem(new OutputSystemDTO(2L, "New Output System (2019-11-05 10.03.23.995)", new OutputSystemTypeDTO(1L, "Generic")))
            .progress(25)
            .state("Failed")
            .statusMessage("this is a status message")
            .reIngestJobPossible(true)
            .reCheckInJobPossible(true)
            .replaceOutputSystemPossible(true)
            .build();

        IngestReportTableModelDTO reportDTO = IngestReportTableModelDTO.builder()
            .captureJobId(UUID.randomUUID())
            .capturedClipName("clipName")
            .outputSystemList(Collections.singletonList(outputSystemDTO))
            .records(Collections.singletonList(recordDTO))
            .abortWorkflowPossible(true)
            .pauseWorkflowPossible(true)
            .resumeWorkflowPossible(true)
            .retryWorkflowPossible(true)
            .build();

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(reportDTO);

        assertNotNull(json);

        IngestReportTableModelDTO dto = mapper.reader()
            .forType(IngestReportTableModelDTO.class).readValue(json);

        assertNotNull(dto);
        assertEquals(reportDTO, dto);

        assertEquals(1, dto.getRecords().size());
        assertEquals(recordDTO, dto.getRecords().get(0));

        assertEquals(1, dto.getOutputSystemList().size());
        assertEquals(outputSystemDTO, dto.getOutputSystemList().get(0));

    }

    @Test
    void builder() {

        final String clipName = "clipName";
        final UUID captureJobId = UUID.randomUUID();

        IngestReportTableModelDTO dto = IngestReportTableModelDTO.builder()
            .captureJobId(captureJobId)
            .capturedClipName(clipName)
            .records(Collections.emptyList())
            .outputSystemList(Collections.emptyList())
            .abortWorkflowPossible(true)
            .pauseWorkflowPossible(true)
            .resumeWorkflowPossible(true)
            .retryWorkflowPossible(true)
            .build();

        assertNotNull(dto);
        assertEquals(clipName, dto.getCapturedClipName());
        assertEquals(captureJobId, dto.getCaptureJobId());
        assertEquals(0, dto.getRecords().size());
        assertEquals(0, dto.getOutputSystemList().size());
        assertTrue(dto.isAbortWorkflowPossible());
        assertTrue(dto.isPauseWorkflowPossible());
        assertTrue(dto.isResumeWorkflowPossible());
        assertTrue(dto.isRetryWorkflowPossible());

    }

}