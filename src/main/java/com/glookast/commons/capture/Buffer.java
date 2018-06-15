package com.glookast.commons.capture;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.glookast.commons.timecode.TimecodeDuration;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
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
}
