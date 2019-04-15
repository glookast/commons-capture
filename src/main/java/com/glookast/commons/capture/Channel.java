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
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, defaultImpl = Channel.class)
public class Channel
{
    protected int id;
    protected ChannelStatus status;
    protected String bufferLocation;
    protected String streamingUrl;
    protected SignalFormat inputSignal;
    protected ReferenceSignalStatus referenceSignalStatus;
    protected Boolean loopRecordingEnabled;
    protected UUID loopRecordingVideoFormatId;
    protected Integer loopRecordingMaxDuration;
    protected Boolean playoutEnabled;
    protected Boolean vtrRecordingEnabled;
    protected String vtrRecordingComPort;

    public Channel(Channel channel)
    {
        this.id = channel.id;
        this.status = channel.status;
        this.bufferLocation = channel.bufferLocation;
        this.streamingUrl = channel.streamingUrl;
        this.inputSignal = channel.inputSignal != null ? new SignalFormat(inputSignal) : null;
        this.referenceSignalStatus = channel.referenceSignalStatus;
        this.loopRecordingEnabled = channel.loopRecordingEnabled;
        this.loopRecordingVideoFormatId = channel.loopRecordingVideoFormatId;
        this.loopRecordingMaxDuration = channel.loopRecordingMaxDuration;
        this.vtrRecordingEnabled = channel.vtrRecordingEnabled;
        this.vtrRecordingComPort = channel.vtrRecordingComPort;
        this.playoutEnabled = channel.playoutEnabled;
    }
}
