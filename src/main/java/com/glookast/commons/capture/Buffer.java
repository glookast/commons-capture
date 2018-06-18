package com.glookast.commons.capture;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.glookast.commons.timecode.TimecodeDuration;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = Buffer.class)
public class Buffer
{
    protected String location;
    protected String fileStore;
    protected long totalSpace;
    protected long availableSpace;
    protected TimecodeDuration totalTime;
    protected TimecodeDuration availableTime;

    public Buffer(Buffer buffer)
    {
        this.location = buffer.location;
        this.fileStore = buffer.fileStore;
        this.totalSpace = buffer.totalSpace;
        this.availableSpace = buffer.availableSpace;
        this.totalTime = buffer.totalTime != null ? new TimecodeDuration(buffer.totalTime) : null;
        this.availableTime = buffer.availableTime != null ? new TimecodeDuration(buffer.availableTime) : null;
    }
}
