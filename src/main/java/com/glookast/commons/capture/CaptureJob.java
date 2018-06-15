package com.glookast.commons.capture;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.glookast.commons.timecode.Timecode;
import com.glookast.commons.timecode.TimecodeDuration;
import com.glookast.commons.timecode.TimecodeSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = CaptureJob.class)
public class CaptureJob
{
    protected UUID id;
    protected UUID parentId;
    protected int channelId;
    protected UUID templateId;
    protected CaptureJobPriority priority;
    protected TimecodeSource timecodeSource;
    protected Timecode startTimecode;
    protected Timecode endTimecode;
    protected TimecodeDuration duration;
    protected Boolean stopOnTimecodeBreak;
    protected Boolean autoRestart;
    protected String externalId;
    protected String clipName;
    protected String tapeName;
    protected Timecode startTimecodeOverride;
    protected String ancDataLines;
    protected AvidCaptureJobProperties avid;
    protected CaptureJobStatus status;
    protected Integer queuePosition;
    protected Timecode actualStartTimecode;
    protected Timecode actualEndTimecode;
    protected TimecodeDuration actualDuration;
    protected OffsetDateTime actualStartDate;
    protected OffsetDateTime actualEndDate;
    protected OffsetDateTime createdDate;
    protected OffsetDateTime modifiedDate;
}
