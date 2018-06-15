package com.glookast.commons.capture;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = TransferJob.class)
public class TransferJob
{
    protected String id;
    protected int channelId;
    protected UUID captureJobId;
    protected UUID transformProfileId;
    protected String transformProfileName;
    protected UUID outputSystemId;
    protected String outputSystemName;
    protected TransferJobStatus status;
    protected String statusMessage;
    protected double progress;
}
