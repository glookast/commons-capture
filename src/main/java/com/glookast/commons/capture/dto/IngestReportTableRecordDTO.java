package com.glookast.commons.capture.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = IngestReportTableRecordDTO.class)
public class IngestReportTableRecordDTO {
    private long id;
    private String codecName;
    private String outputSystemTypeName;
    private String outputSystemName;
    private int progress;
    private String state;
    private String statusMessage;
    private boolean canReIngestJob;
    private boolean canReCheckInJob;
    private boolean canReplaceOutputSystem;
}
