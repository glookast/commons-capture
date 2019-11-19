package com.glookast.commons.capture.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IngestReportTableRecordDTO {
    private final long id;
    private final String codecName;
    private final String outputSystemTypeName;
    private final String outputSystemName;
    private final int progress;
    private final String state;
    private final String statusMessage;
    private final boolean canReIngestJob;
    private final boolean canReCheckInJob;
    private final boolean canReplaceOutputSystem;
}
