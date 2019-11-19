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
    protected TimecodeDuration splitDuration;
    protected TimecodeBreakRule timecodeBreakRule;
    protected String externalId;
    protected String clipName;
    protected String tapeName;
    protected Timecode startTimecodeOverride;
    protected String ancDataLines;
    protected AvidCaptureJobProperties avid;
    protected CaptureJobStatus status;
    protected String statusMessage;
    protected Integer queuePosition;
    protected Timecode actualStartTimecode;
    protected Timecode actualEndTimecode;
    protected TimecodeDuration actualDuration;
    protected OffsetDateTime actualStartDate;
    protected OffsetDateTime actualEndDate;
    protected OffsetDateTime createdDate;
    protected OffsetDateTime modifiedDate;

    public CaptureJob(CaptureJob captureJob)
    {
        this.id = captureJob.id;
        this.parentId = captureJob.parentId;
        this.channelId = captureJob.channelId;
        this.templateId = captureJob.templateId;
        this.priority = captureJob.priority;
        this.timecodeSource = captureJob.timecodeSource;
        this.startTimecode = captureJob.startTimecode != null ? new Timecode(captureJob.startTimecode) : null;
        this.endTimecode = captureJob.endTimecode != null ? new Timecode(captureJob.endTimecode) : null;
        this.duration = captureJob.duration != null ? new TimecodeDuration(captureJob.duration) : null;;
        this.splitDuration = captureJob.splitDuration;
        this.timecodeBreakRule = captureJob.timecodeBreakRule;
        this.externalId = captureJob.externalId;
        this.clipName = captureJob.clipName;
        this.tapeName = captureJob.tapeName;
        this.startTimecodeOverride = captureJob.startTimecodeOverride != null ? new Timecode(captureJob.startTimecodeOverride) : null;
        this.ancDataLines = captureJob.ancDataLines;
        this.avid = captureJob.avid != null ? new AvidCaptureJobProperties(avid) : null;
        this.status = captureJob.status;
        this.statusMessage = captureJob.statusMessage;
        this.queuePosition = captureJob.queuePosition;
        this.actualStartTimecode = captureJob.actualStartTimecode != null ? new Timecode(captureJob.actualStartTimecode) : null;
        this.actualEndTimecode = captureJob.actualEndTimecode != null ? new Timecode(captureJob.actualEndTimecode) : null;
        this.actualDuration = captureJob.actualDuration != null ? new TimecodeDuration(captureJob.actualDuration) : null;
        this.actualStartDate = captureJob.actualStartDate;
        this.actualEndDate = captureJob.actualEndDate;
        this.createdDate = captureJob.createdDate;
        this.modifiedDate = captureJob.modifiedDate;
    }

    public CaptureJob(int channelId, UUID templateId, CaptureJobPriority priority, TimecodeSource timecodeSource, Timecode startTimecode, Timecode endTimecode, TimecodeDuration duration, TimecodeDuration splitDuration, TimecodeBreakRule timecodeBreakRule, String externalId, String clipName, String tapeName, Timecode startTimecodeOverride, String ancDataLines, AvidCaptureJobProperties avid)
    {
        this.channelId = channelId;
        this.templateId = templateId;
        this.priority = priority;
        this.timecodeSource = timecodeSource;
        this.startTimecode = startTimecode;
        this.endTimecode = endTimecode;
        this.duration = duration;
        this.splitDuration = splitDuration;
        this.timecodeBreakRule = timecodeBreakRule;
        this.externalId = externalId;
        this.clipName = clipName;
        this.tapeName = tapeName;
        this.startTimecodeOverride = startTimecodeOverride;
        this.ancDataLines = ancDataLines;
        this.avid = avid;
    }

    public CaptureJob(int channelId, UUID templateId, TimecodeSource timecodeSource, Timecode startTimecode, TimecodeDuration duration, String clipName, String tapeName)
    {
        this.channelId = channelId;
        this.templateId = templateId;
        this.timecodeSource = timecodeSource;
        this.startTimecode = startTimecode;
        this.duration = duration;
        this.clipName = clipName;
        this.tapeName = tapeName;
    }

    public CaptureJob(int channelId, UUID templateId, TimecodeDuration duration)
    {
        this.channelId = channelId;
        this.templateId = templateId;
        this.duration = duration;
    }

    public CaptureJob(int channelId, UUID templateId)
    {
        this.channelId = channelId;
        this.templateId = templateId;
    }
}
