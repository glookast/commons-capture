package com.glookast.commons.capture;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = SoundFormat.class)
public class SoundFormat
{
    protected int channelCount;
    protected int sampleSize;
    protected int samplingRate;

    public SoundFormat(SoundFormat soundFormat)
    {
        this.channelCount = soundFormat.channelCount;
        this.sampleSize = soundFormat.sampleSize;
        this.samplingRate = soundFormat.samplingRate;
    }
}
