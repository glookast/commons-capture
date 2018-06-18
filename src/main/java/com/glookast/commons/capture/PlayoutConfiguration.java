package com.glookast.commons.capture;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.glookast.commons.timecode.TimecodeSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = PlayoutConfiguration.class)
public class PlayoutConfiguration
{
    protected TimecodeSource timecodeSource;
    protected Boolean autoPlayEnabled;
    protected Boolean loopEnabled;

    public PlayoutConfiguration(PlayoutConfiguration playoutConfiguration)
    {
        this.timecodeSource = playoutConfiguration.timecodeSource;
        this.autoPlayEnabled = playoutConfiguration.autoPlayEnabled;
        this.loopEnabled = playoutConfiguration.loopEnabled;
    }
}
