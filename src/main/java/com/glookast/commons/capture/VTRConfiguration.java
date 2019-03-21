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
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = VTRConfiguration.class)
public class VTRConfiguration
{
    protected TimecodeDuration prerollDuration;

    public VTRConfiguration(VTRConfiguration channelConfiguration)
    {
        prerollDuration = channelConfiguration.prerollDuration;
    }
}
