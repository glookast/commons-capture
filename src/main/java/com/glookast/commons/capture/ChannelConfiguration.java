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
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = ChannelConfiguration.class)
public class ChannelConfiguration
{
    protected Boolean loopRecordingEnabled;
    protected UUID loopRecordingVideoFormatId;
    protected Integer loopRecordingMaxDuration;
    protected Boolean vtrRecordingEnabled;
    protected String vtrRecordingComPort;

    public ChannelConfiguration(ChannelConfiguration channelConfiguration)
    {
        this.loopRecordingEnabled = channelConfiguration.loopRecordingEnabled;
        this.loopRecordingVideoFormatId = channelConfiguration.loopRecordingVideoFormatId;
        this.loopRecordingMaxDuration = channelConfiguration.loopRecordingMaxDuration;
        this.vtrRecordingEnabled = channelConfiguration.vtrRecordingEnabled;
        this.vtrRecordingComPort = channelConfiguration.vtrRecordingComPort;
    }
}
