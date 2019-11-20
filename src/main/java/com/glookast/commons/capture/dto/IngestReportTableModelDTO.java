package com.glookast.commons.capture.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * This class contains all relevant information for the Ingest Report dialog component both on Gloobox and CWRC
 * Any other application that represents an Ingest Report should make use of this
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = IngestReportTableModelDTO.class)
public class IngestReportTableModelDTO {

    private final List<String> outputSystemList = new ArrayList<>();
    private final List<IngestReportTableRecordDTO> records = new ArrayList<>();
    private UUID captureJobId;
    private String capturedClipName;
    private boolean canAbortWorkflow;
    private boolean canRetryWorkflow;
    private boolean canPauseWorkflow;
    private boolean canResumeWorkflow;

}