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
    private int id;
    private ChannelStatus status;
    private String bufferLocation;
    private String streamingUrl;
    private SignalFormat inputSignal;
    private ReferenceSignalStatus referenceSignalStatus;
    private Boolean loopRecordingEnabled;
    private UUID loopRecordingVideoFormatId;
    private Integer loopRecordingMaxDuration;
    private Boolean playoutEnabled;
}
