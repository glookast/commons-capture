package com.glookast.commons.capture;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ChannelStatus
{
    @JsonProperty("OFFLINE")
    OFFLINE,
    @JsonProperty("IDLE")
    IDLE,
    @JsonProperty("SCHEDULED")
    SCHEDULED,
    @JsonProperty("RECORDING")
    RECORDING,
    @JsonProperty("ERROR")
    ERROR
}
