
package com.glookast.commons.capture;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.glookast.commons.timecode.Timecode;
import com.glookast.commons.timecode.TimecodeSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = PlayoutStatus.class)
public class PlayoutStatus
{
    protected TimecodeSource timecodeSource;
    protected boolean autoPlayEnabled;
    protected boolean loopEnabled;
    protected String inputChannel;
    protected String outputChannel;
    protected UUID captureJobId;
    protected Double playbackRate;
    protected Long minimumPosition;
    protected Long maximumPosition;
    protected Long position;
    protected Timecode timecode;
}
