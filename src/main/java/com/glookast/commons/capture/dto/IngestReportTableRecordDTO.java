package com.glookast.commons.capture.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.glookast.commons.capture.dto.templates.OutputSystem.OutputSystemDTO;
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
    private Long id;
    private String codecName;
    private OutputSystemDTO outputSystem;
    private OutputSystemDTO altOutputSystem;
    private Integer progress;
    private String state;
    private String statusMessage;
    private boolean reIngestJobPossible;
    private boolean reCheckInJobPossible;
    private boolean replaceOutputSystemPossible;
}
