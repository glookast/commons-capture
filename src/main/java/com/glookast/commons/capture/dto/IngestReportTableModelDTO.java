package com.glookast.commons.capture.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Builder;
import lombok.Data;
import lombok.extern.java.Log;

import java.util.List;
import java.util.UUID;

/**
 * This class contains all relevant information for the Ingest Report dialog component both on Gloobox and CWRC
 * Any other application that represents an Ingest Report should make use of this
 */

@Data
@Log
@Builder
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = IngestReportTableModelDTO.class)
public class IngestReportTableModelDTO {

    private final UUID captureJobId;
    private final String capturedClipName;
    private final List<String> outputSystemList;
    private final List<IngestReportTableRecordDTO> records;
    private final boolean canAbortWorkflow;
    private final boolean canRetryWorkflow;
    private final boolean canPauseWorkflow;
    private final boolean canResumeWorkflow;

}